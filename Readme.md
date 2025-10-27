# Selenium Web Automation Project

This project demonstrates a web automation framework using Selenium, Cucumber, and TestNG.

## Requirements

*   Java Development Kit (JDK) 11
*   Apache Maven
*   Google Chrome

## Folder Structure

```
.
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── java
        │   └── com
        │       └── automation
        │           ├── config
        │           ├── hooks
        │           ├── page
        │           ├── runner
        │           ├── stepdefinitions
        │           └── utils
        └── resources
            ├── configuration.properties
            └── features
                └── login.feature
```

## How to Run the Project

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd selenium-web
    ```
3.  **Run the tests using Maven:**
    ```bash
    mvn test
    ```
    This command will execute the Cucumber tests using TestNG. Test reports can be found in the `target/cucumber-reports` directory.
