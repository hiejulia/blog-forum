# blog-forum
Medium clone with ElasticSearch indexing and Memcache(or Redis ) 



### Tech stack 
+ Spring boot
+ Lombok
+ Restful API
    + API version 
    + API error handling
    + Pagination 
    + Sorting 
+ Cache 
+ Memcache (for caching in the back end )- or redis 
+ MySQL - with Flyway migration 
+ REST doc : Swagger (docs, UI)
+ ElasticSearch 
+ JPA - Hibernate 
+ Docker 


### Features of the project 
+ Database schema as part of Continuous Delivery 
+ Database migration tool - stored in the version control system 
+ Docker image to start MySQL database 
+ 

### Set up docker-compose
+ pack application : `mvn package`
+ start docker-compose : `docker-compose up`


### How to run the project
+ Initial installation 
    + Flyway : `brew install flyway`
    + ElasticSearch : `brew install elasticsearch` 
    + Redis / Memcache  
    
    
+ Flyway CLI Command 
    + `mvn flywayMigrate -i`    
    
    
+ Start ElasticSearch database server (local): `brew services start elasticsearch`    
    + `_cat/indices?v`
    + `/_search?pretty`
    
  
    
    
+ Run with Docker  
    + `docker run --name user-mysql -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql:5.7`
    +    
    
    
    
+ Paging: `?page=0&size=2`
+ Sorting: `?sort=title,asc&sort=id,desc`


### Target
+ Sync data between MySQL and ElasticSearch
+ Performance tuning for MySQL 
+ Performance tuning for ElasticSearch server 
+ Import dump csv file to some table in MySQL database 
+ Bulk insert in MySQL database 
+ Full text index search in 