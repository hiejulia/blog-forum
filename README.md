# blog-forum
Medium clone with ElasticSearch indexing and Memcache(or Redis ) 



### Tech stack 
+ Java 8+
+ Spring boot
+ Lombok
+ Restful API
    + API version 
    + API error handling
    + Pagination 
    + Sorting 
    + Hateoas
+ Memcache or redis 
+ MySQL - with Flyway migration 
+ REST doc : Swagger (docs, UI)
+ ElasticSearch - Kibana (visualize ElasticSearch)
+ JPA - Hibernate 
+ Docker 
+ Logback - LogStash  
+ Messaging  
+ Spring Batch 
+ Spring Integration  
+ AOP - Aspect in Spring framework 
+ Audit entity 



+ Testing : JUnit, Selenium , Robot Framework



### Features of the project 
+ Database schema as part of Continuous Delivery 
+ Database migration tool - stored in the version control system 
+ Docker image to start MySQL database 
+ 

### Set up docker-compose
+ pack application : `mvn package`
+ start docker-compose : `docker-compose up`


### ElasticSearch 
+ Integrate ElasticSearch with Spring 
    + Spring data elasticsearch 
    + Native Elasticsearch Java API 
    + Elasticsearch Rest API 
    + Lightweight Jest client with ElasticSearch 
+ Scale ElasticSearch cluster (production)
+ Secure ElasticSearch cluster 
+ ElasticSearch data back up 
+ Config ElasticSearch
    + Install ES plugins 
    + 
+ ES term 
    + Node : single instance of ES running on machine 
    + Cluster : Single name under which one or more nodes/ instances are connected 
    + Document : JSON (data in key value pair)
    + Doc type : 
    + Index : index using shards and replicas 
    + Shard : containers that can be stored on a single node or multiple nodes are composed of Lucene segments 
    + Replica : duplicate copy of the data living in a shard of high availability
+ ES document analysis and creating mappings 
    + Full text search and inverted indices 
    + Document analysis 
    + Lucene analyzers 
    + Create custom analyzers 
    + ES mappings 
+ Query DSL 
+ Search requests 
+ Sort Data 
+ Document routing 
+ ES aggregation framework: metrics and memory pressure and implications
+ ES bulk operations 
+ Multi search API
+ Data pagination and re index 
+ Bulk processing 
+ Install ES plugin 
+ View mappings 
    + `curl –XGET localhost:9200/index_name/_mapping?pretty`
    + `curl –XGET localhost:9200/index_name/type_name/_mapping?pretty`
    
    



+ ES performance tuning 


### Flyway migration 
+ `mvn flyway:info`
+ `mvn compile flyway:migrate`

### MySQL 
+ Load sample data 
+ Group result (aggregate function)
+ Create user and grant privileges/ access
    +  `CREATE USER IF NOT EXISTS 'company_read_only'@'localhost' 
        IDENTIFIED WITH mysql_native_password 
        BY 'company_pass' 
        WITH MAX_QUERIES_PER_HOUR 500 
        MAX_UPDATES_PER_HOUR 100;`
    + Grant privileges 
        ` GRANT SELECT ON company.* TO 'company_read_only'@'localhost';`
        `GRANT INSERT ON company.* TO 'company_insert_only'@'localhost' IDENTIFIED BY 'xxxx';`
        `GRANT INSERT, DELETE, UPDATE ON company.* TO 'company_write'@'%' IDENTIFIED WITH mysql_native_password AS '*EBD9E3BFD1489CA1EB0D2B4F29F6665F321E8C18';`
    + Create role for user : `CREATE ROLE 'app_read_only', 'app_writes', 'app_developer';`
+ Select data into a file and table 
+ Load data into a table 
+ Join table 
    + Identify duplicate using self join 
    + using sub queries 
    + finding mismatched rows between tables
+ Stored procedured 
+ Functions
+ Triggers 
+ Views / Materialized View 
+ Events
    + `SET GLOBAL event_scheduler = ON;`
+ Getting information about databases and table
    + Table: `SELECT SUM(DATA_LENGTH)/1024/1024 AS DATA_SIZE_MB, SUM(INDEX_LENGTH)/1024/1024 AS INDEX_SIZE_MB, SUM(DATA_FREE)/1024/1024 AS DATA_FREE_MB FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='forumblog';`
    + Column: `SELECT * FROM COLUMNS WHERE TABLE_NAME='forumblog'\G`
    + Files 
    + InnoDB : ` SELECT * FROM INNODB_TABLESPACES WHERE NAME='employees/forumblog'\G`
    + Process list : `SELECT * FROM PROCESSLIST\G`
+ Dump data 





### Messaging JMS
+ Message Type: BytesMessage, MapMessage, ObjectMessage, StreamMessage, TextMesage 


### How to run the project
+ Initial installation 
    + Flyway : `brew install flyway`
    + ElasticSearch : `brew install elasticsearch` 
    + Memcache :  
    + Redis : `brew install redis`
    
+ Flyway CLI Command 
    + `mvn flywayMigrate -i`   
    + `/flyway` 
    
+ Start Elasticsearch server(local) : `elasticsearch`
   
  
    
    
+ Run with Docker  
    + `docker run --name user-mysql -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql:5.7`
    +  To run the ElasticSearch and the application 
        + `docker-compose up `
        + `docker run -p 9200:9200 -p 9300:9300 -v //c/Users/epiobob/Documents/Dev/elastic-spring/src/main/resources/c
           ustom_elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml elasticsearch:2.4.6`  
+ Test when run with Docker 
    + `docker-machine ip <name>`
    + `http get ip:9200`
    
+ Paging: `?page=0&size=2`
+ Sorting: `?sort=title,asc&sort=id,desc`


+ Run test `mvn clean test`

### Target (TODO)
+ Sync data between MySQL and Solr
+ Performance tuning for MySQL 
+ Performance tuning for ElasticSearch server  
+ Import dump csv file to some table in MySQL database 
+ Bulk insert in MySQL database 
+ Full text index search in MySQL 
+ Run ES cluster in Docker container while running integration test 









+ Relational DB + ES 
+ Database      + Indice 
+ Table         + Type 
+ Row           + Document
+ Colume        + Field  