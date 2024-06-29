# Computer Studio Ecommerce Platform

## Overview

This project is an Ecommerce platform focused on building and ordering computer configurations and their associations. The platform uses Spring Data JPA with PostgreSQL as the database. It includes a RESTful API to manage users, products, computers, studios, carts, and orders.

## Technologies Used

- Spring boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Java
- Angular
- TypeScript

## Table of Contents

1. [Installation](#installation)
2. [Usage](#usage)
3. [API Endpoints](#api-endpoints)
4. [Database Models](#database-design)
   

## Installation

### Prerequisites

- Node.js
- PostgreSQL
- Docker (optional, for containerized deployment)

### Steps

1. Clone the repository
    ```sh
    git clone https://github.com/your-repo/ecommerce-platform.git
    cd ecommerce-platform
    ```

2. Install dependencies
    ```sh
    npm install
    ```

3. Set up environment variables
    Create a `.env` file in the root directory and add the following:
    ```env
    DB_HOST=your_db_host
    DB_USER=your_db_user
    DB_PASS=your_db_password
    DB_NAME=your_db_name
    ```

4. Run the application
    ```sh
    npm start
    ```

5. Access the application at `http://localhost:3000`


## API Endpoints

### User Endpoints

- **GET /users**: Get all users
- **POST /users**: Create a new user
- **GET /users/:id**: Get a user by ID
- **PUT /users/:id**: Update a user by ID
- **DELETE /users/:id**: Delete a user by ID

### Product Endpoints

- **GET /products**: Get all products
- **POST /products**: Create a new product
- **GET /products/:id**: Get a product by ID
- **PUT /products/:id**: Update a product by ID
- **DELETE /products/:id**: Delete a product by ID

### Computer Endpoints

- **GET /computers**: Get all computers
- **POST /computers**: Create a new computer
- **GET /computers/:id**: Get a computer by ID
- **PUT /computers/:id**: Update a computer by ID
- **DELETE /computers/:id**: Delete a computer by ID

### Cart Endpoints

- **GET /carts**: Get the current user's cart
- **POST /carts/add**: Add a computer to the current user's cart
- **POST /carts/clear**: Clear the current user's cart

### Order Endpoints

- **GET /orders**: Get all orders
- **POST /orders**: Create a new order
- **GET /orders/:id**: Get an order by ID
- **PUT /orders/:id**: Update an order by ID
- **DELETE /orders/:id**: Delete an order by ID

# Database Design

## Tables

### Users

- **Columns:**
  - `id` (Primary Key, Integer, Auto Increment)
  - `username` (String, Not Null)
  - `password` (String, Not Null)
  - `role` (String, Not Null)
  - `email` (String, Not Null, Unique)

- **Relationships:**
  - One-to-Many with `Carts`
  - One-to-Many with `Orders`

### Products

- **Columns:**
  - `id` (Primary Key, Integer, Auto Increment)
  - `name` (String)
  - `description` (String)
  - `category` (Enum: 'motherboard', 'cpu', 'gpu', 'storage', 'ram', 'psu', 'body')
  - `price` (Float)
  - `imageUrl` (String)

- **Relationships:**
  - One-to-Many with `Computers` (as different components)
  - One-to-Many with `Studios` (as different components)

### Computers

- **Columns:**
  - `id` (Primary Key, Integer, Auto Increment)
  - `total_price` (Float)
  - `description` (String)
  - `name` (String)
  - `motherboard_id` (Foreign Key to `Products`)
  - `cpu_id` (Foreign Key to `Products`)
  - `gpu_id` (Foreign Key to `Products`)
  - `storage_id` (Foreign Key to `Products`)
  - `ram_id` (Foreign Key to `Products`)
  - `psu_id` (Foreign Key to `Products`)
  - `body_id` (Foreign Key to `Products`)

- **Relationships:**
  - Many-to-One with `Carts`
  - Many-to-One with `Orders`
  - Many-to-One with `Products` (as different components)

### Studios

- **Columns:**
  - `id` (Primary Key, Integer, Auto Increment)
  - `name` (String)
  - `motherboard_id` (Foreign Key to `Products`)
  - `cpu_id` (Foreign Key to `Products`)
  - `gpu_id` (Foreign Key to `Products`)
  - `storage_id` (Foreign Key to `Products`)
  - `ram_id` (Foreign Key to `Products`)
  - `psu_id` (Foreign Key to `Products`)
  - `body_id` (Foreign Key to `Products`)

- **Relationships:**
  - Many-to-One with `Products` (as different components)

### Carts

- **Columns:**
  - `id` (Primary Key, Integer, Auto Increment)
  - `user_id` (Foreign Key to `Users`)
  - `total_price` (Float)

- **Relationships:**
  - Many-to-One with `Users`
  - One-to-Many with `Computers`

### Orders

- **Columns:**
  - `id` (Primary Key, Integer, Auto Increment)
  - `user_id` (Foreign Key to `Users`)
  - `total_price` (Float)

- **Relationships:**
  - Many-to-One with `Users`
  - One-to-Many with `Computers`

## Relationships

### Users and Carts

- A `User` can have multiple `Carts`. Each `Cart` is associated with one `User`.
- **Foreign Key:** `user_id` in `Carts` references `id` in `Users`.

### Users and Orders

- A `User` can have multiple `Orders`. Each `Order` is associated with one `User`.
- **Foreign Key:** `user_id` in `Orders` references `id` in `Users`.

### Carts and Computers

- A `Cart` can have multiple `Computers`. Each `Computer` is associated with one `Cart`.
- **Foreign Key:** `cart_id` in `Computers` references `id` in `Carts`.

### Orders and Computers

- An `Order` can have multiple `Computers`. Each `Computer` is associated with one `Order`.
- **Foreign Key:** `order_id` in `Computers` references `id` in `Orders`.

### Products and Computers

- A `Computer` is composed of multiple `Products` (components). Each component (`Product`) can be part of multiple `Computers`.
- **Foreign Keys:** `motherboard_id`, `cpu_id`, `gpu_id`, `storage_id`, `ram_id`, `psu_id`, `body_id` in `Computers` reference `id` in `Products`.

### Products and Studios

- A `Studio` is composed of multiple `Products` (components). Each component (`Product`) can be part of multiple `Studios`.
- **Foreign Keys:** `motherboard_id`, `cpu_id`, `gpu_id`, `storage_id`, `ram_id`, `psu_id`, `body_id` in `Studios` reference `id` in `Products`.


