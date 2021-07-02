# poc-es
Eventsourcing service

- Main language - Kotlin, SpringBoot
- Testing - JUnit5, Mockk, Strikt(Assertions)
- ORM - JPQL(Eclipselink)
- Build - Gradle
- EventStore - AxonServer

## To build

Various gradle tasks are available in project for building & testing whole project

## Development

Under development: features outlined below may not be final.

<!-- prettier-ignore -->
| branch  | ci status | coverage | codacy code quality | notes |
| ------  | --------- | -------- | ------------------- | ----- |
| develop | [![CircleCI](https://circleci.com/gh/ANZi-Credible/credible-es/tree/develop.svg?style=svg&circle-token=10014f7cd71881bdc6fd9d1fd0f6fb8bba974f0a)](https://circleci.com/gh/ANZi-Credible/credible-es/tree/develop) | [codecov badge] | [![Codacy Badge](https://app.codacy.com/project/badge/Grade/e2b6bc19f0b74b28a762dd9aa3debefe)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ANZi-Credible/credible-be&amp;utm_campaign=Badge_Grade) | Work in progress |
| main    | [![CircleCI](https://circleci.com/gh/ANZi-Credible/credible-es/tree/main.svg?style=svg&circle-token=10014f7cd71881bdc6fd9d1fd0f6fb8bba974f0a)](https://circleci.com/gh/ANZi-Credible/credible-es/tree/main) | [codecov badge] | [Codacy badge] | Latest release |

### Git strategy

- Currently, doing trunk based development on forks since team is small.
- Will move to Git flow (feature branches) when needed.

However, every commit message must:

- **start with JIRA ticket no.**
- **tell a concise & clear functional story**
- **use imperative style** e.g. Add tests for 'X' or Fix 'Y' or Create 'Z'

### Deploy code + database for local development

1. Install Docker for IntelliJ(IntelliJ 2020.2.4 provides stable support )
2. Install Docker for desktop(Mac or Windows) & Connect it within IntelliJ
3. Edit the docker-compose.yml configuration
    - add 'clean build' gradle tasks of project 
    - :white_check_mark: --build, force build images
    
   Run `<project>/docker-compose.yml` by clicking on green gutter-icon on 'services' key in file. 
   
4. Open IntelliJ 'Services' view to find 2 containers - tomcat & axonserver running.Both containers will use same
   network(**xxxx-be_default**) as the main application & database. 
5. the docker-compose.yml runs tomcat in debug mode which allows hot reload

### Coding Style

- Keep line length at 120 chars. Hard wrap if exceeds.
- Add KDoc to significant functions in Services etc. Install KDoc-generator plugin for that.
- use explanatory variable names
- Use wildcard imports when class count is high e.g > 10 .Same for static imports (when
  names count is high e.g. > 5 ). Check Preferences -> CodeStyle -> Kotlin

### Import order in Kotlin classes

Define following sequence of imports in IntelliJ settings

```java
// static all other,
java.*, 
javax.*,
kotlin.*,
org.*, 
com.*
 
// all other imports
```

## Deployment

CircleCI config.yml in _.circleci_ folder runs CI/CD pipe-line of following jobs
- code-coverage, 
- build and register ECR image,
- deploy image to ECS cluster

for **_dev,staging_** environments


## Health check url
api health check endpoint is available at
[**host**/app/rest/health] 
[**host**/app/rest/health] 
=> returns ok

## Axon framework
[documentation](https://docs.axoniq.io/reference-guide/v/master/)

[issues forum](https://discuss.axoniq.io/)

