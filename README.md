# Unit Converter Web App

A simple server-side rendered web application built with Java and Spring Boot that converts between different units of measurement. This project transitions from CLI-based applications to a web-based architecture, utilizing the MVC (Model-View-Controller) pattern.

![converter](https://github.com/user-attachments/assets/3d08c2c8-fa1c-4a14-9441-96aeb4846b21)

## Tech Stack

* **Java 21**
* **Spring Boot 3** (Spring Web)
* **Thymeleaf** (Template Engine for Server-Side Rendering)
* **Gradle** (Kotlin DSL)
* **JUnit 5** (Parameterized Unit Testing)

## Features

* **Length Conversion:** Supports meters, centimeters, kilometers, millimeters, inches, feet, yards, and miles.
* **Weight Conversion:** Supports grams, milligrams, kilograms, ounces, and pounds.
* **Temperature Conversion:** Accurately converts between Celsius, Fahrenheit, and Kelvin using specific formula offsets.
* **Dynamic UI:** Uses Thymeleaf conditional rendering to switch seamlessly between input forms and result displays.

## How to Run Locally

1. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/spring-boot-unit-converter.git](https://github.com/your-username/spring-boot-unit-converter.git)
   ```

2. Navigate to the project directory:
   ```bash
   cd spring-boot-unit-converter
   ```

3. Start the Spring Boot server using the Gradle wrapper:
   ```bash
   ./gradlew bootRun
   ```

4. Open your web browser and navigate to:
   ```text
   http://localhost:8080
   ```

## Running Tests

The application includes pure unit tests for the domain logic (mathematical conversions) using JUnit 5 `@ParameterizedTest` to ensure accuracy across multiple edge cases without loading the Spring context.

To run the test suite:
```bash
./gradlew test
```

## Credits

This project idea is based on the [Unit Converter project from roadmap.sh](https://roadmap.sh/projects/unit-converter).
