# FinTrack Backend

## Overview

FinTrack Backend is a finance data processing and access control system.
It allows users to manage financial records (income/expense), apply role-based access, and view dashboard analytics.


## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Spring Security (basic config)
* Swagger (OpenAPI)


## Features

* User management (CRUD)
* Financial record management
* Dashboard analytics (income, expense, category-wise)
* Validation & exception handling
* API documentation using Swagger


## API Documentation (Swagger)

Swagger UI is integrated for easy API testing and documentation.

 Open in browser:
http://localhost:8080/swagger-ui/index.html

### Sample APIs

#### User APIs

* POST `/users` → Create user
* GET `/users` → Get all users
* PUT `/users/{id}` → Update user
* DELETE `/users/{id}` → Delete user

#### Financial Record APIs

* POST `/records` → Create record
* GET `/records` → Get all records
* GET `/records/type/{type}` → Filter by type
* GET `/records/category/{category}` → Filter by category

#### Dashboard APIs

* GET `/dashboard/summary` → Total income, expense, balance
* GET `/dashboard/category` → Category-wise summary



## Screenshots

### Swagger UI

![Swagger UI](screenshots/swagger.png)

## How to Run

1. Clone repository
2. Configure MySQL in `application.properties`
3. Run Spring Boot application
4. Open Swagger UI

## Author

Ayyappa Inukonda
