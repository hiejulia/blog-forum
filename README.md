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


### ElasticSearch 
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




+ ES performance tuning 




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