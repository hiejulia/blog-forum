# blog-forum
Medium clone with ElasticSearch indexing and Memcache(or Redis ) 



### Tech stack 
+ Spring boot
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


### How to run the project
+ Initial installation 
    + Flyway : `brew install flyway`
    + ElasticSearch 
    + Redis / Memcache  
    
    
+ Flyway CLI Command 
    + `mvn flywayMigrate -i`    
    
    
+ Paging: `?page=0&size=2`
+ Sorting: `?sort=title,asc&sort=id,desc`


### Target
+ Sync data between MySQL and ElasticSearch
+ Performance tuning for MySQL 
+ Performance tuning for ElasticSearch server 
+ Import dump csv file to some table in MySQL database 
+ Bulk insert in MySQL database 
+ Full text index search in 