# Selenium Framework - CI/CD
Automated UI testing framework using Selenium , TestNg, Maven with Jenkins CI/CD.

## Tech Stack
-Java 17+
-Selenium WebDriver
-Cucumber BDD + Gherkin
-TestNG
-Maven
-Jenkins
-GitHub Webhooks
-GenAI Copilot for test automation

## Features
-**Page Object Model** design pattern for maintainable tests
-**BDD with Cucumber + Gherkin** for business readable tests scenarios
-**Data Driven Testing** with TestNG DataProvider + Cucumber DataTables
-**GenAI GitHub Copilot Integration** for automated test case generation + overall automation and testing support 
-**Parallel Execution** support
-**CI/CD Integration** with Jenkins + GitHub Webhook
-**Automated Test Reports** via testNG + Cucumber HTML Reports

## CI/CD Pipeline
1. Code pushed to GitHub 'fixed' branch
2. GitHub Webhooks triggers Jenkins job automatically
3. Jenkins pulls code and runs 'mvn clean test'
4. TestNG HTML reports generated in Jenkins

## How to Run Locally
 
### Prerequisites
-Java 17+ installed
-Maven 3.9+ installed

**Clone the Repo**
git clone https://github.com/RiaadQATest/SeleniumFrameworkAutomationCI-CD.git

cd SeleniumFrameworkAutomationCI-CD
**Run Test**

mvn clean test




