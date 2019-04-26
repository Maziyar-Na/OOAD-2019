(function () {
    var app = angular.module('Library', ['ngRoute', 'ngCookies']);


    app.config(function($routeProvider, $locationProvider) {

        $routeProvider
            .when('/', {
               templateUrl : 'index.html',
               controller  : 'searchController'
            })

            .when('/login', {
               templateUrl : 'Login.html',
               controller  : 'loginController'
            })

            .when('/result', {
                templateUrl : 'SearchResult.html',
                controller  : 'ResultController'
            })

            .when('/cart', {
                templateUrl : 'Cart.html',
                controller  : 'cartController'
            })
            .when('/receipt', {
                templateUrl : 'Receipt.html',
                controller  : 'ReceiptController'
            })

            .when('/bookreturn', {
                templateUrl : 'bookReturn.html',
                controller  : 'returnController'
            })

            .when('/bookops', {
                templateUrl : 'bookOperations.html',
                controller  : 'bookOperationController'
            })

            .when('/reg', {
                templateUrl : 'register.html',
                controller  : 'userController'
            });

        // use the HTML5 History API
        //$locationProvider.html5Mode(true);
    });


    app.factory('sharedList', function() {
        var list = [];

        return {
            setList: setList,
            getList: getList
        };

        function setList(tlist) {
            list = tlist;
        }

        function getList() {
            return list;
        }
    });


    app.controller(
      "loginController",
      function ($scope, $http, $cookies, sharedList, $location) {
          localRef = this;
          this.userInfo={};

          this.marshal = function(userInfo) {
              return {
                  username: userInfo.username,
                  password: userInfo.password
              };
          };

          this.doLogin = function(userInfo){
              //alert("we are here!");
              console.log(userInfo);
              $http.post('http://localhost:8080/GLibrary/library/loginmanagement/login' ,
                  this.marshal(this.userInfo)).then(
                  function(response) {
                      console.log(response.data);
                      if(response.data == -1){
                          alert("Username or password is incorrect. Try again!")
                      }
                      else{
                          alert("Login was successful");
                          $cookies.put("accessLevel" , response.data);
                          $location.url('/');
                      }
                  }
              );
          };
      }
    );


    app.controller(
        "searchController",
        function ($scope, $http, $cookies, sharedList ,$location) {
            localRef = this;

            this.bookInfo={};
            this.loginReps = [];

            this.login = true ;
            this.cart = false ;
            this.patron = false ;
            this.book = false ;
            this.returnbook = false ;

            if ($cookies.get('accessLevel') != undefined) {
                this.login = false ;
                if($cookies.get('accessLevel') == 2 || $cookies.get('accessLevel') == 3){
                    this.book = true ;
                }
                if($cookies.get('accessLevel') == 2){
                    this.patron = true ;
                }
                if($cookies.get('accessLevel') == 3){
                    this.returnbook = true ;
                }
            }

            console.log(this.login);

            this.marshal = function(bookInfo) {
                return {
                    book_name: bookInfo.book_name,
                    author: bookInfo.author,
                    isbn_num: bookInfo.isbn_num,
                    since_date:bookInfo.since_date
                };
            };

            this.doSearch = function(bookInfo){
                //alert("we are here!");
                console.log(bookInfo);
                localRef = this;
                $http.post('http://localhost:8080/GLibrary/library/searchmanagement/search' ,
                    this.marshal(this.bookInfo)).then(
                    function(response) {
                        sharedList.setList(response.data);
                        console.log(sharedList.getList());
                        //console.log(response.data);
                        $location.url('/result');
                    }
                );
            };
        }
    );



    app.controller("ResultController", function($scope, $http, $cookies, sharedList, $location){
        localRef = this;
        this.searchResults = sharedList.getList();
        this.cart = []
        this.sortType = 1;
        if ( $cookies.get('cart') != undefined)
            this.cart = JSON.parse($cookies.get('cart'));
        console.log(this.searchResults);

        this.addToCart = function(index){
            alert("click ok to continue reserving!");
            console.log(index);
            console.log(this.searchResults[index]);
            this.cart.push(this.searchResults[index]);
            console.log(this.cart);
            $cookies.put('cart', JSON.stringify(this.cart));
        };

        this.goToCheckout = function(){
            $location.url("/cart");
        };
        
        this.sort = function (sortType) {
            $http.post('http://localhost:8080/GLibrary/library/searchmanagement/sort='+this.sortType ,
                this.searchResults).then(
                function(response) {
                    localRef.searchResults = response.data;
                    console.log(localRef.searchResults);
                }
            );
        }

    });

    app.controller("cartController", function($scope, $http, $cookies, sharedList, $location){
        localRef = this;
        this.cart = [];
        if ($cookies.get("accessLevel" )  == undefined || $cookies.get("accessLevel" ) == 1){
            this.showReserve = true;
        }
        else if($cookies.get("accessLevel" ) == 2 || $cookies.get("accessLevel" ) == 3){
            this.showReserve = false;
        }

        if($cookies.get('cart') != undefined) {
            this.cart = JSON.parse($cookies.get('cart'));
            console.log(this.cart);
        }

        this.removeFromCart = function(index){
            alert("click ok to continue reserving!");
            console.log(index);
            console.log(this.cart[index]);
            this.cart.splice(index, 1);
            console.log(this.cart);
            $cookies.put('cart', JSON.stringify(this.cart));
        };

        this.marshal = function(booksInfo) {
            var res = [];
            console.log(booksInfo);
            for (index in booksInfo){
                console.log(booksInfo[index]);
                var item = {};
                item.book_name = booksInfo[index].book_name ;
                item.author = booksInfo[index].author;
                item.isbn_num = booksInfo[index].isbn_num;
                item.since_date = booksInfo[index].since_date;
                item.available = booksInfo[index].available;
                item.type = booksInfo[index].type;
                res.push(item);
            }
            console.log(res);
            return res ;
        };

        this.reserve = function(){
            //alert("we are here!");
            console.log(this.cart);
            $http.post('http://localhost:8080/GLibrary/library/reservemanagement/reserve' ,
                this.marshal(this.cart)).then(
                function(response) {
                    console.log(response.data);
                    if(response.data == true) {
                        console.log(localRef.cart);
                        sharedList.setList(localRef.cart);
                        $cookies.put('cart', undefined) ;
                        $location.url('/receipt');
                    }
                    else {
                        alert("You should login first");
                        $location.url('/login')
                    }
                }
            );
        };

    });

    app.controller("ReceiptController", function($scope, $http, $cookies, sharedList, $location){
        localRef = this;
        this.reserved = sharedList.getList();
        console.log(this.reserved);

    });


    app.controller(
        "returnController",
        function ($scope, $http, $cookies, sharedList ,$location) {
            localRef = this;

            this.returnInfo={};

            this.marshal = function(returnInfo) {
                return {
                    username: returnInfo.username,
                    book_name: returnInfo.book_name,
                    isbn_num: returnInfo.isbn_num
                };
            };

            this.calculate_fee = function(returnInfo){
                console.log(returnInfo);
                $http.post('http://localhost:8080/GLibrary/library/returnmanagement/calculate_fee' ,
                    this.marshal(this.returnInfo)).then(
                    function(response) {
                        localRef.fee = response.data;
                    }
                );
            };

            this.doReturn = function(returnInfo){
                console.log(returnInfo);
                $http.post('http://localhost:8080/GLibrary/library/returnmanagement/return' ,
                    this.marshal(this.returnInfo)).then(
                    function(response) {
                        console.log(response.data);
                        if(response.data == 0){
                            alert("returned!");
                        }
                        else{
                            alert("wrong Info!");
                        }
                    }
                );
            };
        }
    );

    app.controller("bookOperationController", function($scope, $http, $cookies, sharedList, $location){
        localRef = this;
        this.bookInfo={};
        console.log(this.bookInfo);

        this.marshal = function(bookInfo) {
            return {
                book_name: bookInfo.book_name,
                author: bookInfo.author,
                isbn_num: bookInfo.isbn_num,
                since_date:bookInfo.since_date,
                type: bookInfo.type,
                available: bookInfo.available
            };
        };

        this.addBook = function(){
            //alert("we are here!");
            console.log(this.bookInfo);
            $http.post('http://localhost:8080/GLibrary/library/bookmanagement/add' ,
                this.marshal(this.bookInfo)).then(
                function(response) {
                    console.log(response.data);
                    if(response.data == true)
                        alert("The book is successfully added!");
                    else {
                        alert("Try Again!");
                    }
                }
            );
        };

        this.deleteBook = function(){
            //alert("we are here!");
            console.log(this.bookInfo);
            $http.post('http://localhost:8080/GLibrary/library/bookmanagement/delete' ,
                this.marshal(this.bookInfo)).then(
                function(response) {
                    console.log(response.data);
                    if(response.data == true)
                        alert("The book is successfully deleted!");
                    else {
                        alert("No book with such information you provided!");
                    }
                }
            );
        };

    });

    app.controller("userController", function($scope, $http, $cookies, sharedList, $location){
        localRef = this;
        this.userInfo={};
        console.log(this.userInfo);

        this.marshal = function(userInfo) {
            return {
                username: userInfo.username,
                password: userInfo.password,
                firstname: userInfo.firstname,
                lastname: userInfo.lastname,
                type: 1
            };
        };

        this.addUser = function(){
            //alert("we are here!");
            console.log(this.userInfo);
            $http.post('http://localhost:8080/GLibrary/library/usermanagement/add' ,
                this.marshal(this.userInfo)).then(
                function(response) {
                    console.log(response.data);
                    if(response.data == 0){
                        alert("The user is successfully added!");
                    }
                    else if (response.data == -2){
                        alert("This username already exists! Choose another one");
                    }
                    else {
                        alert("Some internal Error happenedTry Again!");
                    }
                }
            );
        };

        this.cancelUser = function(){
            //alert("we are here!");
            console.log(this.bookInfo);
            $location.url('/')
        };

    });

})();