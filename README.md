# Diplom_3
Проект: Дипломный проект Яндекс.Практикума. Часть 3. Тестирование веб приложения.

## Use
* Java 11,
* Junit 4.13.2,
* RestAssured 5.3.1,
* AspectJ 1.9.6,
* Allure 2.24.0,
* maven 3.9.3

## For start test with Google Chrome
`mvn clean test -Dbrowser=chrome`
## For start test with Yandex
`mvn clean test -Dbrowser=yandex`
## For start test with Mozilla FireFox
`mvn clean test -Dbrowser=firefox`

## For create  a report in Allure
`mvn allure:serve`