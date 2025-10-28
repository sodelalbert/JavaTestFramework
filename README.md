# Java Test Framework

Minimal Java + Maven test framework using JUnit Jupiter and Microsoft Playwright. Includes sample API, E2E, and Performance tests.

## Prerequisites
- Java 24+
- Maven 3.6+

## Quick Start
1) Install dependencies
```
mvn clean install
```
2) (Optional for E2E) Install Playwright browsers
```
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```
3) Run tests
```
mvn test
```

## Run specific suites
```
# API tests
mvn test -Dtest=SampleApiTestSuite

# E2E tests
mvn test -Dtest=SampleE2ETestSuite

# Performance tests
mvn test -Dtest=SamplePerfTestSuite
```

## Configuration
Edit `src/test/resources/config.properties`:
```
url.frontend=www.test.com
url.backend=www.test.backend.com
```
Use in code:
```
String url = config.Config.get("url.frontend");
```
