ConfigServer has all the config related all microservices like employee, api-gateway, department under resources/config/<sprin.application.name>.yaml

Api gateway do service discovery based on the routes 

used spring reactive webflux for communcation between microservices (HttpExchange)

Zipkin for distributed tracing

Spring 3.4.1
Java 17

"C:\Program Files\Amazon Corretto\jdk17.0.10_7\bin\java.exe" -jar zipkin-server-3.4.4-exec.jar
