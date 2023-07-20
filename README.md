### Schema

```
                   +-------------+
                   |             |
                   |  PostgreSQL |
                   |             |
                   +------+------+
                          |
                          |
                          |
          +---------------v------------------+
          |                                  |
          |           Kafka Connect          |
          |    (Debezium, ES connectors)     |
          |                                  |
          +---------------+------------------+
                          |
                          |
                          |
                          |
                  +-------v--------+
                  |                |
                  | Elasticsearch  |
                  |                |
                  +----------------+


```
We are using Docker Compose to deploy the following components:

* PostgreSQL
* Kafka
    * ZooKeeper
    * Kafka Broker
    * Kafka Connect with [Debezium](http://debezium.io/) and [Elasticsearch](https://github.com/confluentinc/kafka-connect-elasticsearch) Connectors
* Elasticsearch

### Usage
1) 
```shell
docker-compose up --build
# wait until it's setup
```
2) Download Kafka Connect Elastic Sink Connector https://www.confluent.io/hub/confluentinc/kafka-connect-elasticsearch
- Extract downloaded zip file
- Rename lib folder into kafka-connect-jdbc
- Copy kafka-connect-jdbc into debezium the container of kafka-connect
```shell
docker cp /!path-to-file!/confluentinc-kafka-connect-elasticsearch-!version!/kafka-connect-jdbc/* connect:/kafka/connect/
```
- Verify that all dependency is copied
```shell
docker exec -it connect /bin/bash
$ cd connect/kafka-connect-jdbc/
$ ls -all
```
- Restart Debezium Kafka Connect container
```shell
docker stop connect
docker start connect
```
3) Create source and elasticsearch connections
```shell
./start.sh
```
4) Run application