# E-Commerce Microservice Architecture

## Overview
This project consists of four microservices built using the Spring Framework in Java:
- **Products Service**: Manages product information.
- **Orders Service**: Handles customer orders.
- **Admin Service**: Administers product and order management.
- **Image Service**: Manages product images.

## Architecture
Each microservice is designed to be independent and stateless, with communication handled via REST APIs and Kafka for asynchronous messaging.

## Docker and Containerization
All microservices and databases are containerized using Docker, with a single `docker-compose.yml` file orchestrating the entire deployment.

## API Gateway
An API Gateway routes external requests to the appropriate microservices, hiding internal service endpoints.

## Communication
- **REST APIs**: Used for synchronous communication between the API Gateway and microservices.
- **Kafka**: Used for asynchronous communication, particularly for order processing and product stock updates.

## Database
Each service uses its own MySQL database, managed in a Docker container. The database schemas are designed to store relevant information such as products, orders, and images.

## Frontend
A basic UI allows users to browse products, view details, add them to a cart, and make purchases.

