# spring-cloud-microservices

http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/1000
http://localhost:8765/currency-conversion-service/currency-converter/from/USD/to/INR/quantity/1000
http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
http://localhost:8761/
http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/1000
http://localhost:8001/h2-console/login.do?jsessionid=624a6e2f6c48914dddfe8d2ac2220c46
http://localhost:8000/currency-exchange/from/USD/to/INR
http://localhost:8000/h2-console/login.do?jsessionid=a391577eddd652358960322e59c2c04d

### Installing Rabbit MQ

#### Windows
- https://www.rabbitmq.com/install-windows.html
- https://www.rabbitmq.com/which-erlang.html
- http://www.erlang.org/downloads
- Video - https://www.youtube.com/watch?v=gKzKUmtOwR4

#### Mac
- https://www.rabbitmq.com/install-homebrew.html
##### Installation Directory on MAC
-/usr/local/Cellar/rabbitmq/3.7.5

To have launchd start rabbitmq now and restart at login:
  brew services start rabbitmq
Or, if you don't want/need a background service you can just run:
  rabbitmq-server
  
  # RabbitMQ Admin UI
  - http://localhost:15672/#/
  
  # Start Zipkin with RabbitMQ
  - RABBIT_URI=amqp://localhost java -jar zipkin.jar
  # Zipkin Admin UI
  - http://localhost:9411/zipkin/
