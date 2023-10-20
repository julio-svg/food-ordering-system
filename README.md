# food-ordering-system 
Microservices: Clean Architecture, DDD, SAGA, Outbox & Kafka

--- 
## order-service
order-service, modules:
* order-application: API layer, REST Controller
* order-dataaccess: Data layer, RDBMS
* order-domain: Domain layer, Bussines logic
    * order-domain-core: Domain
    * order-application-service: Service application
* order-messaging: Messaging component
* order-container: Jar and container generator for order-service 


