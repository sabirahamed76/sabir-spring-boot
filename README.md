Register Microservices in Eureka Server
---------------------------------------

1) Start the Eureka Server

2) Start the Provider Application (CartService)

3) Start the Consumer Application (PaymentService)

4) Click on Payment Service link on Eureka screen
It will be like : http://192.168.0.7:8989/actuator/info

5) Modify URL path as: ‘/payment/data’ in place of ‘/actuator/info’ and hit Enter.
http://192.168.0.7:8989/payment/data# sabir-spring-boot
