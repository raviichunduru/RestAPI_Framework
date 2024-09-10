# 🦾 restpro

Test RestAPIS like a PRO.

![build status](https://img.shields.io/github/actions/workflow/status/raviichunduru/RestAPI_Framework/trigger-new-updated-and-unit-tests-on-pull-request.yml?logo=GitHub)
![open issues](https://img.shields.io/github/issues/raviichunduru/RestAPI_Framework)
![forks](https://img.shields.io/github/forks/raviichunduru/RestAPI_Framework)
![stars](https://img.shields.io/github/stars/raviichunduru/RestAPI_Framework)
![license](https://img.shields.io/github/license/raviichunduru/RestAPI_Framework?style=flat-square)
![languages](https://img.shields.io/github/languages/count/raviichunduru/RestAPI_Framework)

## Application under test

[Restful booker](https://restful-booker.herokuapp.com/) - An API playground created by [Mark Winteringham](https://www.mwtestconsultancy.co.uk/) for those wanting to learn more about API testing and tools.

## 🔢 Requiring (one time) manual setup by user

1. [**JDK 11**](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) - as language of choice
   for writing this test framework.
2. [**Maven 3.8.6+**](https://maven.apache.org/) - for project dependency management and running tests in CI.
3. [**pre-commit**](docs/README-CODE-FORMATTING.md) - To have code automatically and uniformly formatted (JAVA, JSON,
   XML, YAML).

## 🚀 Core features

- [x] Shows how to create a decoupled test design (that minimises maintenance efforts by reducing code
  duplication and increases code readability by separating test intentions from implementation details).
- [x] Allows users to write fluent assertions for asserting both status and response body, without any code duplication.
- [x] Creates APIs that are scope/role agnostic. This allows you to use the same APIs and data to write tests for
  different user roles and scopes.
- [x] Shows how to provide different token types for different role/scopes using a TokenFactory pattern.
- [x] Shows how to reuse the same auth token in all the tests for same role/scope using a Singleton pattern.
- [ ] Shows how to use health checks in the test CI to have efficient pipelines.
- [ ] Shows how to insert test data dynamically in each test.

## 🎯 Standard features

- [ ] Shows how to integrate your tests in CI (GitHub Actions).
- [ ] Shows how to log your test results into a test monitoring system (such as Elastic/Kibana or DataDog)
- [x] Shows how to do JSON Schema validation.
- [x] Shows how to separate config from code.
- [x] Shows how to deal with Secrets in local and in CI. Also on how to skip logging secret information on console.
- [ ] More to be added...

## ⚙ Tool Set

Key tools to be used in this core framework are:

- [x] **Java** (As the core programming language)
- [x] **Maven** (for automatic dependency management)
- [x] **Junit 5** (for assertions)
- [x] **RestAssured**  (library for Rest API automation)
- [x] **Slf4J/Log4J** (for logging interface and as a logging library)
- [x] **Typesafe** (for application configuration for multiple test environments)
- [x] **Git crypt** (for managing secrets)
- [x] **Surefire** (for xml reports in CI)
- [x] **Surefire Site plugin** (for html reports in CI)
- [x] **GitHub** (for version control)
- [x] **GitHub actions** (for continuous integration)
- [x] **Faker library** (for generating random test data for different locales - germany, france, netherlands, english)
- [x] **Slack integration** (for giving notifications on pull requests)
- [x] **Elastic and Kibana** (for test monitoring)
- [ ] **Docker** (for automating test framework's environment)
- [ ] **SonarQube/SonarLint** (for keeping your code clean and safe)
- [x] **Badges** (for a quick view on your project meta and build status)

## 🧪 api-test-design

![api-test-design](./images/api-test-framework-design.png)

## 🔚 end-to-end-test-workflow

![end-to-end-test-workflow](./images/end-to-end-test-workflow.png)

## ℹ References

- <a href="https://rest-assured.io/" target="_blank">Rest-assured</a>
- [Application under test (restful-booker)](https://restful-booker.herokuapp.com/apidoc/index.html)
- [http-response-handling-api-reference](https://www.jetbrains.com/help/idea/http-response-handling-api-reference.html)

## 🔌 Plugins

- [HOCON](https://plugins.jetbrains.com/plugin/10481-hocon) - For config and secrets files syntax highlight.
- [.ignore](https://plugins.jetbrains.com/plugin/7495--ignore) - For (dockerignore, gitignore) files syntax highlight.
