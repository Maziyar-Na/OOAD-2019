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
          /*this.validLogin = true;*/

          this.userInfo={};
          this.loginReps = [];

          this.marshal = function(userInfo) {
              return {
                  username: userInfo.username,
                  password: userInfo.password
              };
          };

          this.doLogin = function(userInfo){
              //alert("we are here!");
              console.log(userInfo);
              localRef = this;
              $http.post('http://localhost:8080/GLibrary/library/loginmanagement/login' ,
                  this.marshal(this.userInfo)).then(
                  function(response) {
                      console.log(response.data);
                      if(response.data != 0){
                          alert("Username or password is incorrect. Try again!")
                      }
                      else{
                          alert("Login was successful");
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

    });

    app.controller("cartController", function($scope, $http, $cookies, sharedList, $location){
        localRef = this;
        this.cart = JSON.parse($cookies.get('cart'));
        console.log(this.cart);

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
                    if(response.data == true)
                        $location.url('/receipt');
                    else {
                        alert("You should login first");
                        $location.url('/login')
                    }
                }
            );
        };

    });

})();