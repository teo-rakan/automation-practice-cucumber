Demo repository for automated testing with BDD of a demo e-commerce website: http://automationpractice.com.

#### Java + Maven + Cucumber + PicoContainer + Selenide + Allure

Default maven goal: `clean test`.
Default browser is Google Chrome.
The cucumber-java8 module was used to create step definitions (using lambda expressions).

For testing with Mozilla Firefox the `firefox` command line parameter can be used:
```bash
mvn test -Pfirefox
```
