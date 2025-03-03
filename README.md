# Management_app - Spring Boot REST API

## Overview

This is a Spring Boot-based management application that provides RESTful APIs for managing customers, Products. The following API endpoints allow for creating, updating, deleting, retrieving, and searching records.
## Project Structure
```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───deneth
│   │   │           └───management_app
│   │   │               ├───api
│   │   │               ├───dto
│   │   │               │   ├───request
│   │   │               │   └───response
│   │   │               │       └───Paginate
│   │   │               ├───entity
│   │   │               ├───repository
│   │   │               ├───service
│   │   │               │   └───impl
│   │   │               └───util
│   │   └───resources
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───deneth
│                   └───management_app
```
## Customer Base URL

```
http://localhost:8081/api/v1/customers
```

## Customer API Endpoints

| Method     | Endpoint                          | Description                                             |
| ---------- | --------------------------------- | ------------------------------------------------------- |
| **POST**   | `/create`                         | Creates a new customer record.                          |
| **PUT**    | `/update/{id}`                    | Updates an existing customer record using the given ID. |
| **DELETE** | `/delete/{id}`                    | Deletes a customer record based on the given ID.        |
| **GET**    | `/find-by-id/{id}`                | Retrieves a customer record based on the given ID.      |
| **GET**    | `/search?searchText=&page=&size=` | Searches for customers using query parameters.          |
| **PUT**    | `/change-state/{id}`              | Changes the state of a customer record using the given ID. |

## Products Base URL

```
http://localhost:8081/api/v1/products
```

## Products API Endpoints

| Method  | Endpoint                 | Description                                   |
|---------|--------------------------|-----------------------------------------------|
| POST    | `/`                      | Create a new product                         |
| PUT     | `/{id}`                  | Update an existing product                   |
| GET     | `/{id}`                  | Retrieve a product by ID                     |
| GET     | `/search`                 | Search for products with pagination          |
| DELETE  | `/{id}`                  | Delete a product by ID                       |
| PUT     | `/change-qty/{id}`       | Update the quantity of a product by ID       |



## Dependencies
- **Spring Boot Starter Data JPA**  
- **Spring Boot Starter Web**  
- **Spring Boot DevTools**  
- **MySQL Connector/J**  
- **Lombok**  
- **Spring Boot Starter Test**
