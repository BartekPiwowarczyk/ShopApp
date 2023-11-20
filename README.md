# Shop online

---

## Online store application


The application is designed for **managing your online store**
and **online shopping for users** (both logged in and not logged in).

Administrator functions include:

* Add and edit products and categories
* Manage orders and export them to a .csv file
* Review order statistics
* Manage customers reviews 
 
User functions include:

* Registration and login
* Browse products categorized by type
* Add products to the shopping cart
* Edit the quantity of products to be ordered
* Place an order, provide personal information, choose a delivery method, and select a payment method
* Complete the purchase by making payments through a bank transfer or using a payment gateway

---
## Technologies:
<a href="https://www.java.com" target="_blank" rel="noreferrer"><img src="https://ultimateqa.com/wp-content/uploads/2020/12/Java-logo-icon-1.png" alt="java" width="80" height="50"/></a> 
<a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://e4developer.com/wp-content/uploads/2018/01/spring-boot.png" alt="spring" width="90" height="50"/> 
<a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="60" height="60"/> </a>
<a href="https://www.h2database.com/html/main.html" target="_blank" rel="noreferrer"> <img src="https://www.h2database.com/html/images/h2-logo-2.png" alt="mysql" width="70" height="40"/> </a>
<a href="https://www.liquibase.org/" target="_blank" rel="noreferrer"> <img src="https://liquibase.org/wp-content/themes/liquibase/assets/img/logo-org.svg" alt="liquibase" width="80" height="50"/> </a>
<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://junit.org/junit4/images/junit5-banner.png" alt="java" width="90" height="50"/>
<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://javadoc.io/static/org.mockito/mockito-core/1.9.5/org/mockito/logo.jpg" alt="java" width="90" height="50"/></a> 

---
## Run application:

### You have 3 ways to run application:
#### 1. Run following links on Heroku:
Backend with Swagger: https://shop-app-bpiw-b7a002c8bc28.herokuapp.com/swagger-ui/index.html#/ </br>
Frontend: https://shop-app-frontend-bpiw-87a4f4ccafaf.herokuapp.com/
#### 2. Run Demo profile with H2 database in memory on your local machnie
* Install IntelliJ IDEA on your computer.
* Clone the repository in IntelliJ IDEA using the link https://github.com/BartekPiwowarczyk/ShopApp
* Run the application in IntelliJ IDEA with Active Profile **demo** (*VM options: -Dspring.profiles.active=demo*) </br>
and Environment variables: --app.email.sender=fakeEmailService [^1]
* Try the applications in Postaman, the steps on how to do it are below.

---

[^1]: This option sets the mail-sending service to use a demo mode after placing an order, allowing the sent message to be visible in the application logs.

