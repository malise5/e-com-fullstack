# Product Management Application

This is a product management application built using **React** for the frontend and **Java Spring Boot** for the backend. The application provides features for managing products, including viewing, filtering, and sorting them by categories.

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [System Requirements](#system-requirements)
- [Setup and Installation](#setup-and-installation)
  - [Frontend Setup](#frontend-setup)
  - [Backend Setup](#backend-setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Deployment](#deployment)
- [Security Considerations](#security-considerations)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

The Product Management Application is designed to streamline product management processes. It provides a user-friendly interface for interacting with product data and a robust backend for handling business logic and data persistence.

---

## Features

- **Product Management**: View, filter, and sort products.
- **Category Management**: Fetch and display product categories.
- **Responsive Design**: Optimized for both desktop and mobile devices.
- **RESTful API**: Exposes endpoints for seamless integration with other systems.

---

## Technologies Used

### Frontend:
- React
- Tailwind CSS (for styling)
- Fetch API (for backend communication)

### Backend:
- Java Spring Boot
- JPA/Hibernate (for ORM)
- Spring Data REST (for API exposure)
- H2 Database (default, with support for MySQL or PostgreSQL)

---

## System Requirements

- **Frontend**:
  - Node.js v16 or later
  - npm v8 or later

- **Backend**:
  - Java 11 or later
  - Maven 3.6 or later
  - Optional: MySQL/PostgreSQL for production database

---

## Setup and Installation

### Frontend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/malise5/e-com-fullstack.git
   cd e-com-fullstack/frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```

The frontend will be available at [http://localhost:5173](http://localhost:5173).

---

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/malise5/e-com-fullstack.git
   cd e-com-fullstack/backend
   ```

2. Build the application:
   ```bash
   mvn clean install
   ```

3. Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

The backend will be available at [http://localhost:8081](http://localhost:8081).

#### Database Configuration
- By default, the application uses an in-memory H2 database.
- To use MySQL or PostgreSQL, update the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

---

## Running the Application

1. Start the backend server by following the [Backend Setup](#backend-setup) instructions.
2. Start the frontend server by following the [Frontend Setup](#frontend-setup) instructions.
3. Open [http://localhost:3000](http://localhost:3000) in your browser to access the application.

---

## API Documentation

### Products
- `GET /api/products/all` – Fetch all products.
- `GET /api/products/{id}` – Fetch a specific product by ID.

### Categories
- `GET /api/categories/all` – Fetch all product categories.

#### Example Response for `/api/products/all`:
```json
[
  {
    "id": 1,
    "name": "Product 1",
    "category": "Category A",
    "price": 99.99,
    "description": "A great product"
  },
  {
    "id": 2,
    "name": "Product 2",
    "category": "Category B",
    "price": 149.99,
    "description": "Another awesome product"
  }
]
```

#### Example Response for `/api/categories/all`:
```json
[
  "Category A",
  "Category B",
  "Category C"
]
```

---

## Testing

### Frontend Testing
- Run unit tests using Jest:
   ```bash
   npm test
   ```

### Backend Testing
- Run unit and integration tests using Maven:
   ```bash
   mvn test
   ```

---

## Deployment

### Frontend Deployment
1. Build the production-ready frontend:
   ```bash
   npm run build
   ```
2. Deploy the `build/` directory to your web server (e.g., Nginx, Apache).

### Backend Deployment
1. Package the backend as a JAR file:
   ```bash
   mvn clean package
   ```
2. Deploy the JAR file to your application server (e.g., Tomcat, AWS Elastic Beanstalk).

---

## Security Considerations

- **Environment Variables**: Store sensitive data (e.g., database credentials, API keys) in environment variables.
- **HTTPS**: Use HTTPS for secure communication in production.
- **CORS**: Configure CORS policies to restrict access to trusted domains.
- **Authentication**: Implement authentication and authorization for sensitive endpoints.

---

## Contributing

We welcome contributions! If you'd like to contribute, follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a pull request.

---

## License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or support, please contact [halkanomalise@gmail.com](mailto:halkanomalise@gmail.com).