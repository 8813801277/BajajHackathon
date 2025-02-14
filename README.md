# Bajaj Application

This is a demo project for Spring Boot that includes user authentication, JWT token generation, and MongoDB integration.

## Project Structure
                ## Prerequisites

- Java 21
- Maven
- MongoDB

## Getting Started

1. **Clone the repository:**
    ```sh
    git clone <repository-url>
    cd Bajaj
    ```

2. **Configure MongoDB:**
    Ensure MongoDB is running and accessible at [mongodb://localhost:27017/bajaj](http://_vscodecontentref_/4). You can change the MongoDB URI in [application.properties](http://_vscodecontentref_/5).

3. **Build the project:**
    ```sh
    ./mvnw clean install
    ```

4. **Run the application:**
    ```sh
    ./mvnw spring-boot:run
    ```

## Endpoints

### Authentication

- **Add User:**
    ```http
    POST /api/add
    ```
    Request Body:
    ```json
    {
        "username": "your_username",
        "password": "your_password"
    }
    ```

- **Login:**
    ```http
    POST /api/login
    ```
    Request Body:
    ```json
    {
        "username": "your_username",
        "password": "your_password"
    }
    ```

### User Dashboard

- **Get Dashboard:**
    ```http
    GET /api/dashboard?username=your_username
    ```

- **Update Activity:**
    ```http
    GET /api/upActivity?username=your_username&count=10&act=pushUps
    ```

## Security

This project uses Spring Security with JWT for authentication. The JWT token is generated upon successful login and must be included in the `Authorization` header for subsequent requests.

## License

This project is licensed under the Apache License 2.0. See the LICENSE file for details.
