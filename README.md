# QA Automation Framework (UI & API)

Automated testing framework for **SauceDemo** (UI) and **ReqRes** (API) built with Java, designed to demonstrate modern QA automation practices, architectural patterns, and reporting tools.

---

## 🛠️ Tech Stack

* **Language:** Java 20
* **Test Framework:** JUnit 5
* **UI Testing:** Selenide (Page Object Pattern)
* **API Testing:** REST Assured, Jackson (JSON serialization/deserialization)
* **Build Tool:** Maven
* **Reporting & Attachments:** Allure Report (Auto-screenshots & Page source on test failure)

---

## 📂 Project Architecture

The project follows a **Layered Architecture** with strict separation of concerns:
```text
src/
├── main/
│   ├── java/
│   │   ├── api/          # REST Assured API clients and service endpoints
│   │   ├── models/       # POJO data models (Jackson mapping)
│   │   └── pages/        # Page Object classes (Selenide elements and actions)
│   └── resources/
└── test/
    └── java/
        └── tests/        # Test suites (UI & API tests, Parameterized tests)
🚀 Key Features & Test Scenarios
UI Tests (SauceDemo):

Successful login and product cart validation.

Parameterized negative login scenarios using Equivalence Partitioning (empty username, empty password, locked-out user with full error message validation).

API Tests (ReqRes):

Automated REST API authentication requests and response validation.

Reporting & Diagnostics:

Full integration with Allure Framework using custom annotations (@Step, @Severity, @Owner, @DisplayName).

Automatic Attachments: On test failure, Selenide & Allure automatically capture a browser screenshot and save the HTML page source.

⚙️ Local Execution
Prerequisites
JDK 20+ installed and configured in JAVA_HOME.

Maven installed.

Google Chrome browser.

Run Tests and Generate Report
To run the test suite and automatically serve the Allure report locally, execute the following command in the project terminal:

Bash
mvn clean test allure:serve
📊 Allure Report Overview
Example of test execution with Allure annotations, steps, and automatic failure attachments:

Categories: Smoke, Regression

Severities: Blocker, Critical, Normal


---
