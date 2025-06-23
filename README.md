# Selenium Alert Management Framework

A comprehensive Selenium automation framework for testing JavaScript alerts with Java, TestNG, Maven, and Allure reporting.

## Project Overview

This framework is designed to test the JavaScript alerts functionality on [The Internet Herokuapp](https://the-internet.herokuapp.com/javascript_alerts) website. It includes:

- **Base Test Class**: Common WebDriver setup, screenshot management, and utility methods
- **Page Object Model**: Organized locators and page-specific methods
- **Allure Reporting**: Comprehensive test reporting with screenshots for failed tests
- **Screenshot Manager**: Automatic screenshot capture for failed test cases
- **Multiple Locator Strategies**: XPath, CSS Selector support

## Technology Stack

- **Java**: 17
- **Selenium WebDriver**: 4.15.0
- **TestNG**: 7.8.0
- **Maven**: Latest
- **Allure**: 2.24.0
- **WebDriverManager**: 5.6.2

## Project Structure

```
src/
├── main/java/com/selenium/
│   ├── base/
│   │   └── BaseTest.java          # Base test class with WebDriver setup
│   └── pages/
│       └── JavaScriptAlertsPage.java  # Page object for alerts page
└── test/java/com/selenium/
    └── tests/
        └── JavaScriptAlertsTest.java   # Test cases
```

## Features

### 1. Base Test Class (`BaseTest.java`)
- WebDriver setup with Chrome browser
- Screenshot capture for failed tests
- Common utility methods for element interactions
- Alert handling methods
- Explicit wait implementations

### 2. Page Object (`JavaScriptAlertsPage.java`)
- All locators for the JavaScript alerts page
- Multiple XPath strategies as requested:
  - `/html/body/div[2]/div/div/ul/li[2]/button`
  - `//*[@id="content"]/div/ul/li[2]/button`
  - `#content > div > ul > li:nth-child(2) > button`
- Page-specific methods for interactions

### 3. Test Cases (`JavaScriptAlertsTest.java`)
- Test JavaScript Confirm Alert with Dismiss (main test)
- Test JavaScript Confirm Alert with Accept
- Test JavaScript Alert with Accept
- Test using CSS Selector
- Page elements presence verification

### 4. Allure Reporting
- Detailed test reports with screenshots
- Test categorization with Epics, Features, Stories
- Severity levels for test prioritization
- Step-by-step test execution details

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Chrome browser

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd SeleniumAlertManagement
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run tests**
   ```bash
   mvn clean test
   ```

4. **Generate Allure report**
   ```bash
   mvn allure:report
   ```

5. **Open Allure report**
   ```bash
   mvn allure:serve
   ```

## Test Execution

### Run all tests
```bash
mvn clean test
```

### Run specific test class
```bash
mvn test -Dtest=JavaScriptAlertsTest
```

### Run with specific TestNG XML
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Key Test Scenarios

### 1. JavaScript Confirm Alert Dismiss Test
- **Objective**: Click on JS Confirm button and dismiss the alert
- **XPath Used**: `/html/body/div[2]/div/div/ul/li[2]/button`
- **Verification**: Result text contains "Cancel"
- **Severity**: CRITICAL

### 2. JavaScript Confirm Alert Accept Test
- **Objective**: Click on JS Confirm button and accept the alert
- **XPath Used**: `//*[@id="content"]/div/ul/li[2]/button`
- **Verification**: Result text contains "Ok"
- **Severity**: NORMAL

### 3. CSS Selector Test
- **Objective**: Use CSS selector to click JS Confirm button
- **Selector**: `#content > div > ul > li:nth-child(2) > button`
- **Verification**: Result text contains "Cancel"
- **Severity**: MINOR

## Allure Report Features

### Screenshots
- Automatic screenshot capture for failed tests
- Screenshots attached to Allure reports
- Stored in `/screenshots/` directory

### Test Categories
- **Epic**: JavaScript Alerts Management
- **Feature**: Alert Handling
- **Stories**: Various user interactions with alerts

### Severity Levels
- **CRITICAL**: Main test scenario
- **NORMAL**: Standard alert interactions
- **MINOR**: Additional verification tests

## XPath Strategies Implemented

As requested, the framework includes multiple XPath strategies for the JS Confirm button:

1. **Absolute XPath**: `/html/body/div[2]/div/div/ul/li[2]/button`
2. **Relative XPath with ID**: `//*[@id="content"]/div/ul/li[2]/button`
3. **CSS Selector**: `#content > div > ul > li:nth-child(2) > button`

## Configuration

### Browser Configuration
- Chrome browser with maximized window
- Disabled notifications and popup blocking
- Implicit wait: 10 seconds
- Explicit wait: 10 seconds

### Screenshot Configuration
- Screenshots saved in `screenshots/` directory
- PNG format
- Automatic capture on test failure

## Troubleshooting

### Common Issues

1. **WebDriver not found**
   - Solution: WebDriverManager automatically downloads drivers

2. **Tests failing due to timing**
   - Solution: Framework includes explicit waits for all elements

3. **Screenshots not generated**
   - Check if `/screenshots/` directory exists
   - Ensure write permissions

### Debug Mode
Run tests with debug logging:
```bash
mvn test -Dorg.slf4j.simpleLogger.defaultLogLevel=debug
```

## Contributing

1. Follow the existing code structure
2. Add appropriate Allure annotations
3. Include screenshots for new test scenarios
4. Update documentation

## License

This project is for educational and testing purposes. 