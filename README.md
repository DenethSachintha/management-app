# E-Commerce Application - Spring Boot REST API

## Overview

This is a Spring Boot-based e-commerce application that provides RESTful APIs for managing customers. The following API endpoints allow for creating, updating, deleting, retrieving, and searching customer records.

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

### Request & Response Examples

#### 1. Create Customer

**Request:**

```json
{
    "name": "Deneth",
    "address": "Hikkaduwa",
    "salary": 230000
}
```

**Response:** `201 Created`

#### 2. Update Customer

**Request:**

```json
{
    "name": "Deneth",
    "address": "Rathmalana",
    "salary": 230000
}
```

**Response:** `201 Updated`

#### 3. Delete Customer

**Response:** `204 No Content`

#### 4. Find Customer by ID

**Response:** `200 OK` (Customer details in JSON format)

#### 5. Search Customers

**Example Request:**

```
GET /search?searchText=Deneth&page=1&size=10
```

**Response:** `200 OK` (List of matching customers)

#### 6. Change Customer State

**Example Request:**
```
PUT /change-state/{id}
```

**Response:** `200 OK`

## Dependencies
- **Spring Boot Starter Data JPA**  
- **Spring Boot Starter Web**  
- **Spring Boot DevTools**  
- **MySQL Connector/J**  
- **Lombok**  
- **Spring Boot Starter Test**
