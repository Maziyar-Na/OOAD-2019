__OOAD Spring 2019__

<h2>Project Name: Library System Web Application</h2>

<h4>Team Members:</h4>
- Sepideh Goodarzy
- Maram Kurdi
- Dwight Browne
- Maziyar Nazari

<h4>Overview:</h4>

A web application implemented to automate some basic procedures which are being done in a library. This functionalities include the following:

- Have implemented different access levels for 3 types of people: Patron, Librarian and Admin (in Login phase)

- Have implemented the feature to search for items in the library

- Have implemented the feature to be able to sort the search results based on different criteria

- Have implemented a functionality in which Patron can add/remove items to his/her cart and submit his/her request to borrow some items

- Have implemented a functionality in which Librarian can add/delete items to/from inventory

- Have implemented a functionality in which Admin can register a new Patron

- Have implemented a functionality in which the librarian can request to return an item which was borrowed before, on behalf of the user who got the item and getting the late fees(if there was any) out of the system and receive the late fee from the Patron and then Patron can request to borrow another item

<h4>Description of the files in repo:</h4>

The Library folder is the final project. 

> Library/src: includes all the source codes.

> Library/src/main/java: Includes all java codes and packages.

> Library/src/main/java/DAO: Includes all Java classes which play role as data access objects. They are responsible for knowing the interface of the database(how to deal with database which here is MySQL) and get the requests from the domain layer and make an appropriate query to send it to the database, then send back an appropriate well-shaped response to the domain layer.

> Library/src/main/java/domain: This package includes all of the classes needed for the core logic of the program. all of the objects other that Data Access Objects are in this package(layer) and talk to each other based on class diagram relations and provide the core functionality of the system.

> Library/src/main/java/service: all of the java servlets that accept the request from the frontend side are in this folder's packages. Different services like search management, login management, etc are assigned to different URLs so that when we want to call some service like "login" we will request to the URL of the login management service and use the response which it will provide to the frontend side.

> Library/src/main/webapp: includes all html pages which we have in the frontend side of our web application. in other words the view+controller layer of our app.

> Library/src/main/webapp/assets/js: includes all of the js files which we used in our web app and includes the controllers implemented using AngularJS, pure JS and JQuery.

> Library/src/main/webapp/WEB-INF: includes web.xml configuration file that Apache Tomcat server needs to route frontend request correctly to the java servlets

> Library/pom.xml: Used by maven build tool. Using this type of file we can configure and mention how the project will be built. For example, adding dependencies(like junit,etc), mention plugins needed, the way that we want our project being built(war, jar,etc).

> *** You can find the description of each single file is provided under the "purpose" tag in the file itself

Notes on Installing and Executing:
Prerequisites: 
- MySQL
- Apache Tomcat 9
- Maven

Executing: 

- Download the Library folder
*** Note: if you have an IDE like Intellij you can simply open the folder in you IDE.

*** Note: Make sure that you have pom.xml file and src folder

- Reimport the maven project's dependencies in Intellij IDEA. Or run "mvn build" to download the dependencies needed for the project.

- Run MySQL db and write down the port on which MySQL daemon runs.

- Import your tomcat server folder into the project you made in Intellij IDEA.

- import the database which we provided in the repo (the MySQL dump / .sql file) in your local MySQL DB in a database named Library.

- Change the database connection string which is in the ConnectionDAO.java in the Library/src/main/java/DAO folder to your own database url created.

- Simply in intellij IDEA click on run to run the project.

- if you do not have intellij IDEA, you need to produce the war file at first using the "mvn install" command, then copy the war file in your tomcat folder and then run Apache tomcat in the terminal(./startup.sh)

- Enjoy!

