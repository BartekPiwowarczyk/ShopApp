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
#### 1. Run Demo profile with H2 database in memory on your local machine
* Install IntelliJ IDEA on your computer.
* Clone the repository in IntelliJ IDEA using the link https://github.com/BartekPiwowarczyk/ShopApp
* Run the application in IntelliJ IDEA with Active Profile **demo** (*VM options: `-Dspring.profiles.active=demo`*) </br>
and Environment variables: `--app.email.sender=fakeEmailService` [^1]
* Try the applications in Postman, the steps on how to do it are below.
* You don't have to log in if you want to try out admin endpoints

#### 2. Run default profile with MySQL database
* Install IntelliJ IDEA on your computer.
* Clone the repository in IntelliJ IDEA using the link https://github.com/BartekPiwowarczyk/ShopApp
* Run the application in IntelliJ IDEA Environment variables: `--app.email.sender=fakeEmailService` [^1]
* Try the applications in Postman, the steps on how to do it are below.
* You must log in if you want to try out admin endpoints (Demo profile give permit to all endpoints)
#### 3. Run following links on Heroku:
Backend: https://shop-app-bpiw-b7a002c8bc28.herokuapp.com/ </br>
Frontend: https://shop-app-frontend-bpiw-87a4f4ccafaf.herokuapp.com/

Only with this option, you can use the Przelewy24 payment gateway, which uses an external API.

* You must log in if you want to try out admin endpoints
---

## Postman

**Use baseUrl -> http://localhost:8080 or https://shop-app-bpiw-b7a002c8bc28.herokuapp.com/**

List of example important endpoints:

Authorization
* [POST /register](###POST/register)
* [POST /login](###POST/login)

Categories
* [GET /admin/categories](###GET/admin/categories)
* [POST /admin/categories](###POST/admin/categories)

Products
* [POST /admin/products](###POST/admin/products)
* [GET /products/{slug}](###GET/products/{slug})
* [PUT /admin/products/{id}](###PUT/admin/products/{id})
* [DELETE /admin/products/{id}](###DELETE/admin/products/{id})

Carts
* [PUT /carts/{id}](###PUT/carts/{id})

Orders
* [POST /orders](###POST/orders)
* [GET /orders](###GET/orders)

Reviews
* [POST /reviews](###POST/reviews)
* [PUT /admin/reviews/{id}/moderate](###PUT/admin/reviews/{id}/moderate)




### POST/register

You can add new user to database. This user don't have access to admin endpoints.

```shell
POST baseUrl/register
JSON:
{
"username":"Jan",
"password":"password12",
"repeatPassword":"password12",
}
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/blob/master/screenshots/postman_register.png" width="500" heigt="700"/>

### POST/login

You can log in to a account created by you or to the admin account. Response body is token with you need if you want use admin endpoints in header: Authorization
```shell
POST baseUrl/login
JSON:
{
"username":"admin",
"password":"test"
}
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_login.PNG" width="500" heigt="700"/>

### GET/admin/categories

This endpoint uses authorization and return all categories 

```shell
GET baseUrl/admin/categories
HEADERS:
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNzAzMTUyMTk4fQ.GjNbRyZ5bfTPCG9MmUTMysxZ7uWYfmSmAM51C2MdySg
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_get_categories.PNG" width="500" heigt="700"/>


### POST/admin/categories

This endpoint uses authorization and add new category

```shell
POST baseUrl/admin/categories
HEADERS:
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNzAzMTUyMTk4fQ.GjNbRyZ5bfTPCG9MmUTMysxZ7uWYfmSmAM51C2MdySg
JSON:
{
  "name": "school",
  "description": "books, workbooks, pencils, pens",
  "slug": "school"
}
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_post_categories.PNG" width="500" heigt="700"/>

### POST/admin/products

This endpoint uses authorization and add new product. Firstly, you need to have any category in the database

```shell
POST baseUrl/admin/products
HEADERS:
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNzAzMTUyMTk4fQ.GjNbRyZ5bfTPCG9MmUTMysxZ7uWYfmSmAM51C2MdySg
JSON:
{
  "name": "Red pen",
  "categoryId": 2,
  "description": "nice red pen",
  "fullDescription": "",
  "price": 3,
  "salePrice": 1,
  "currency": "PLN",
  "image": "",
  "slug": "red  pen"
}
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_post_products.PNG" width="500" heigt="700"/>

### GET/products/{slug}

This endpoint returns detailed information about a product in the database using a specially prepared `slug` prefix.
To use it, you need to have a product in the database and know the slug (you can use the previous endpoint for testing).

```shell
GET baseUrl/products/red-pen
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_get_products_slug.PNG" width="500" heigt="700"/>

### PUT/admin/products/{id}

This endpoint uses authorization and edit product. Firstly, you need to have any product in the database
In this example I change price and description. 

```shell
PUT baseUrl/admin/products/4
HEADERS:
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNzAzMTUyMTk4fQ.GjNbRyZ5bfTPCG9MmUTMysxZ7uWYfmSmAM51C2MdySg
JSON:
{
  "name": "Red pen",
  "categoryId": 2,
  "description": "nice big red pen",
  "fullDescription": "",
  "price": 4.00,
  "salePrice": 3.00,
  "currency": "PLN",
  "image": "",
  "slug": "red-pen"
}
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_put_products_id.PNG" width="500" heigt="700"/>


### DELETE/admin/products/{id}

This endpoint uses authorization and delete product. Firstly, you need to have any product in the database

```shell
DELETE baseUrl/admin/products/3
HEADERS:
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNzAzMTUyMTk4fQ.GjNbRyZ5bfTPCG9MmUTMysxZ7uWYfmSmAM51C2MdySg
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_delete_products_id.PNG" width="500" heigt="700"/>


### PUT/carts/{id}

This endpoint adds a product to an existing cart or creates a new cart and then add the product (always increments the quantity by 1). Firstly, you need to have any product in the database


```shell
PUT baseUrl/carts/1
JSON:
{
  "productId": 4,
  "quantity": 1
}
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_put_carts_id.PNG" width="500" heigt="700"/>

### POST/orders

This endpoint add order to database.Firstly, you need to have any cart, payment method and shipment method in the database.
I added basic payment options (bank transfer, Przelewy24 payment gateway) and basic delivery options (delivery man, self pickup).

At the end, the cart is cleared, a confirmation email is sent, and information about the order, along with the order status, is returned.

If the order is paid through the Przelewy24, the status will be changed to "paid".

If we have the option set to `--app.email.sender=fakeEmailService`, a sample email message will be displayed in the logs.

If we have the option set to `--app.email.sender=emailSimpleService`, a confirmation message about placing the order will be sent to us.

**ATTENTION: If you are using localhost, the Przelewy24 option is not available.**

```shell
POST baseUrl/orders
JSON:
  {
  "firstname": "Jan",
  "lastname": "Nowak",
  "street": "niska",
  "zipcode": "12345",
  "city": "Krakow",
  "email": "jan@pl.pl",
  "phone": "111222333",
  "cartId": 1,
  "shipmentId": 1,
  "paymentId": 1
}
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_orders.PNG" width="500" heigt="700"/>

### GET/orders


This endpoint show all example user orders.

In this example I use admin account with done one order.

```shell
GET baseUrl/orders
HEADERS:
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNzAzMTY2MzE4fQ.hBMzjl5DNK-PpvSl-P6SKP9nupvNb-Qkevwze3hEPgU
```
<img src="https://github.com/BartekPiwowarczyk/ShopApp/screenshots/postman_get_orders.PNG" width="500" heigt="700"/>

---
[^1]: This option sets the mail-sending service to use a demo mode after placing an order, allowing the sent message to be visible in the application logs.

