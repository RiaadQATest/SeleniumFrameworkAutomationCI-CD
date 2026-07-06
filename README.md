# Selenium Framework - CI/CD
Automated UI testing framework using Selenium , TestNg, Maven with Jenkins CI/CD.

## Tech Stack
-Java 17+
-Selenium WebDriver
-TestNG
-Maven
-Jenkins
-GitHub Webhooks

## Features
-**Page Object Model** design pattern for maintainable tests
-**Data Driven Testing** with TestNG DataProvider
-**Parallel Execution**support
-**CI/CD Integration** with Jenkins + GitHub Webhook
-**Automated Test Reports** via testNG

## CI/CD Pipeline
1. Code pushed to GitHub 'main' branch
2. GitHub Webhooks triggers Jenkins job automatically
3. Jenkins pulls code and runs 'mvn clean test'
4. TestNG HTML reports generated in Jenkins

## How to Run Locally
 
### Prerequisites
-Java 17+ installed
-Maven 3.9+ installed

###
**Clone the Repo**
'''bash
git clone https://github.com/RiaadQATest/SeleniumFrameworkAutomationCI-CD.git
cd SeleniumFrameworkAutomationCI-CD
**Run Test**
mvn clean test



