<h3 align="center">
    Proof of Concept with Spring to demonstrate observability
</h3>

<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/dansilva41/poc-observability?color=%2304D361">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/dansilva41/poc-observability">

  <a href="https://github.com/dansilva41/poc-observability/commits/main">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/dansilva41/poc-observability">
  </a>

   <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
   <a href="https://github.com/dansilva41/poc-observability/stargazers">
    <img alt="MIT License" src="https://img.shields.io/github/stars/dansilva41/poc-observability?style=social">
  </a>

  <a href="https://danilosilva.tk">
    <img alt="made by Danilo Silva" src="https://img.shields.io/badge/made%20by-Danilo%20Silva-blue">
  </a>

  <a href="https://developers-friends.gitbook.io/">
    <img alt="Developer's Friends" src="https://img.shields.io/badge/Blog-Developers%20Friends-orange">
    </a> 
</p>

<p align="center">
 <a href="#dizzy-about">About</a> • 
 <a href="#rocket-technologies">Technologies</a> •
 <a href="#computer-building-locally">Building Locally</a> •
 <a href="#memo-license">License</a>

</p>

## :dizzy: About

POC with Spring, Logback, Graylog, Prometheus and Grafana, to demonstrate log structuring, sensitive data masking, traceability, metrics and dashboards with alerts.

---
## :rocket: Technologies

The project was developed using the following technologies

- [Spring Boot]()
- [Lombok]()
- [Logback]()
- [MDC]()
- [Prometheus]()
- [Grafana]()

---
## :computer: Building Locally

### Requirements

- [Java 17]()
- [Docker]()

### Install

1. Clone the repository

   `git clone git@github.com:DanSilva41/poc-observability`

2. Enter directory

   `cd poc-observability`

3. Install dependencies

   `./gradlew clean build`

### Run application

    `./gradlew bootRun`

Open http://localhost:8080/actuator

## See Logs
### Run Graylog

    `cd logs && docker-compose up`

Open http://localhost:9000

## See metrics and dashboard
### Run Prometheus and Grafana

    `cd metrics && docker-compose up`

**Prometheus**: http://localhost:9090 <br/>
**Grafana**: http://localhost:3000

---
## :memo: License
This project is under the MIT license. See the [LICENSE](https://github.com/dansilva41/poc-observability/blob/main/LICENSE) for more information.

Developed by Danilo Silva :wave: [Get in touch!](https://www.linkedin.com/in/danilosilvap/)

[Spring]: https://spring.io/
[Logback]: https://logback.qos.ch/
[Graylog]: https://www.graylog.org/
[MDC]: https://logback.qos.ch/manual/mdc.html
[Prometheus]: https://prometheus.io/
[Grafana]: https://grafana.com/
[Lombok]: https://projectlombok.org/
[Docker]: https://www.docker.com/
[Java 17]: https://sdkman.io/jdks