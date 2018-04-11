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
+ Solr server
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
    + Solr : `brew install solr` 
    + Memcache :  
    
    
+ Flyway CLI Command 
    + `mvn flywayMigrate -i`   
    + `/flyway` 
    
    
+ Start Solr server (local)
    + `solr start`
    
  
    
    
+ Run with Docker  
    + `docker run --name user-mysql -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql:5.7`
    +    
    
    
    
+ Paging: `?page=0&size=2`
+ Sorting: `?sort=title,asc&sort=id,desc`


### Target (TODO)
+ Sync data between MySQL and Solr
+ Performance tuning for MySQL 
+ Performance tuning for Solr server  
+ Import dump csv file to some table in MySQL database 
+ Bulk insert in MySQL database 
+ Full text index search in 