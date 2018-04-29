# blog-forum
Medium clone with ElasticSearch indexing and Memcache 

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
+ Memcache
+ MySQL - with Flyway migration 
+ REST doc : Swagger (docs, UI)
+ ElasticSearch - Kibana (visualize ElasticSearch)
+ JPA - Hibernate 
+ Docker - Docker-compose
+ Logback - LogStash  
+ Messaging : RabbitMQ 
+ Spring Batch 
+ Spring Integration  
+ AOP - Aspect in Spring framework 
+ Audit entity 
+ Testing : JUnit, Selenium , Robot Framework
+ Spring Scheduling 

### Features of the project 
+ Database schema as part of Continuous Delivery 
+ Database migration tool - stored in the version control system 
+ Docker image to start MySQL database 

### Set up docker-compose
+ pack application : `mvn package`
+ start docker-compose : `docker-compose up`
+ Run RabbitMQ server with 

### Set up RabbitMQ with Vagrant
+ `vagrant up` : start the RabbitMQ with Vagrant box 
+ `vagrant halt`: stop the RabbitMQ with Vagrant box 
+ Go to : `http://localhost:15672`

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
+ location : `<location>filesystem:${project.basedir}/src/main/resources/db/migration</location>`

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
+ Binary log 
    + Replication 
    + Point in time recovery 
    + Enable binary logs - expire binary log 
+ Back up database project 
    + Logical back up 
    + Physical back up 
+ Replication 
    + Master-master replication
    + Multi source replication 
    + Master-slave replication 
+ Security : 
    + Secure installation 
    + Restrict networks and users 
    + Password-less authentication using mysql_config_editor 
    + Reset the root password 
    + Set up encrypted connections using X509 
    + Set up SSL replication
+ Performance tuning 
    + explain plan 
    + benchmarking queries and the server
        + Time query report 
        + mysqlslap utility 
        + run multiple sqls in a file 
        + emulate client load using mysqlslap  
    + add index 
    + invisible index 
    + descending index 
    + analyzing slow queries using pt-query-digest
        + slow query log 
        + general query log 
        + process list 
        + binary log 
        + TCP dump  
    + optimizing data type 
        + procedure analyzer 
    + check index usage 
        + pt-index-usage 
        + sys schema
    + query optimizer
        + passing hints to the query / or by adjust  
    + index hint
    + index for json 
    + resource group 
    + performance_schema 
    + sys schema 
    + remove redundant index 
        + tool: pt-duplicate-key-checker, mysqlindexcheck, sys schema 
+ Managing logs 
    + Error log 
        + `SELECT @@global.log_error_services;`
        + Config error log 
        + Rotate the log - write a bash script to automate - put into cron 
        + Error log in JSON format 
    + Query log 
        + Specify the file for logging 
        + Enable general query log 
            + `SET GLOBAL general_log = 'ON';`
    + Binary log
        + Check fot the slave servers in binary log 
        + Connect to any of the servers and execute the mysqlbinlogpurge script:    
    + Relay log 
    + DDL log
+ Table maintainance 
    + 
+ Index data with high performance data 
    + Index structure: Bitmap, Sparse, Dense, B Tree, Hash index 
    + Index JSON data 
        + Virtual generaated column 
        + Stored generated columns
+ Full text search index
+ Natural language fulltext search on InnoDB and MyISAM
+ Spartial index 
    + geo data 
    + multidimensional data 
+ Using memcached with Mysql 
    + Set up Memcached 
        + Install Memcache plugin : daemon_memcached 
        + Config script : `source <MYSQL_HOME>/share/innodb_memcached_config.sql` (execute script)
        + Activate daemon_memcached plugin : `INSTALL PLUGIN daemon_memcached soname "libmemcached.so";`
    + Analyze data stored in memcached
        + check `telnet 11211`
    + Memcached replication config
        + Enable binary log replication 
        + Edit the config file 
        + Set the replication master and slave 
        + Take a backup of the master database and restore it in all of the slave server 
        + Obtain master binary log 
        + Start slave server 
+ Partitioning data 
    + Horizontal partitioning
        + Each partition of the table contains the same number of columns 
        + Range partitioning
            + `PARTITION BY RANGE (UNIX_TIMESTAMP(access_date)) ( 
PARTITION p0 VALUES LESS THAN (UNIX_TIMESTAMP('2017-05-01 00:00:00')), 
PARTITION p1 VALUES LESS THAN (UNIX_TIMESTAMP('2017-09-01 00:00:00')), 
PARTITION p2 VALUES LESS THAN (UNIX_TIMESTAMP('2018-01-01 00:00:00')), 
PARTITION p3 VALUES LESS THAN (UNIX_TIMESTAMP('2018-05-01 00:00:00')), 
PARTITION p4 VALUES LESS THAN (UNIX_TIMESTAMP('2018-09-01 00:00:00')), 
PARTITION p5 VALUES LESS THAN (UNIX_TIMESTAMP('2019-01-01 00:00:00')), 
);`
        + List partitioning
            + `PARTITION BY LIST(website_id) ( 
PARTITION PartitionNorth VALUES IN (1,2), 
PARTITION PartitionSouth VALUES IN (3,4), 
PARTITION PartitionWest VALUES IN (5,6), 
PARTITION PartitionEast VALUES IN (7,8) 
);`
        + Hash partitioning 
            + `PARTITION BY HASH(website_id) 
PARTITIONS 4;
`
        + Columns partitioning
            + Range column partition
            + List column partition 
        + Key partitioning 
        + Sub partitioning
    + Vertical partitioning 
        + Normalize the table 
    + Pruning partitioning
    + Query on partitioned data 
        + 

+ Replication 

+ Mysql benchmark and configuration 
+ Resource utilization : IO, CPU 
+ Set up MySQL metrics : sysbench 
+ Concurrency 
+ Optimizer 
+ Fetch all table / column name from InnoDB table 
    + SELECT t.table_schema, t.table_name, c.column_name
FROM information_schema.tables t,
information_schema.columns c
WHERE t.table_schema = c.table_schema
AND t.table_name = c.table_name
AND t.engine='InnoDB';
+ Best practice for queries : 
    + Data type 
    + Not null
    + Index 
    + Compound index 
    + Do not use fetch all `select *`
    + Analyze slow query 
    + Using explain for query explain
    + Backlog queue limit 
    + Large page support 
    + Infrastructure sizing 
    + Write scalability 
        + Multi master to distribute load
+ Replication 
    + High availability 
    + Replication 
    + Group replication 
    + Master-slave replication 
    + MySLQ cluster 
    + MySQL with Solaris cluster 
    + Data replication 
    + Clustered and virtualized system 
    + Replication : master-slave 
        + Write : master 
        + Read : slave 
        + Sync between master and slave through configuration 
    + Scalable system :     
+ Security : back up MySQL database 
+ Method for replication
    + Read the binary logs : sync between master - slave 
    + Replication using global transaction identifiers
    + Replication configuration
    + Replication master config - replication for 
+ GTID replication - transaction-base 
+ MySQL multisource replication 

+ Group replication 
    + Transaction 
    + Server commit files
    + Group replication diagram 
    + Group repication config
    + Group replication settings
    + Choose single master or multi-master 
    + Host-specific configuration 
    + Config replication user and enable group replication plugin 
    + Start group replication

+ Multi-source replication 

+ Globalization in MySQL 
    + Character sets 
    + Language selection 
+ Server SQL mode 
    + 

+ Scalability and high availability
    + Replication 
        + Master-slave 
    + Cluster : automate sharing 
+ Scaling MySQL 8 
    + Scaling using cluster 
        + Client node 
        + Application node 
        + Management node 
        + Data node 
            + Data storage and management of disk based and in memory data 
            + Partitioning of tables or sharding of tables 
            + Sync data replication between data nodes
            + Data retrieve and transaction 
            + Re sync 
            + Scale memcached 

+ High availability 

+ Partitioning in MySQL 
    + Range partition 
        + `CREATE TABLE employee (
    employee_id INT NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    hired_date DATE NOT NULL DEFAULT '1990-01-01',
    termination_date DATE NOT NULL DEFAULT '9999-12-31',
    job_code INT NOT NULL,
    store_id INT NOT NULL
)
PARTITION BY RANGE (store_id) (
    PARTITION p0 VALUES LESS THAN (6),
    PARTITION p1 VALUES LESS THAN (11),
    PARTITION p2 VALUES LESS THAN (16),
    PARTITION p3 VALUES LESS THAN (21),
    PARTITION p4 VALUES LESS THAN (26)
);`
    + List partition 
        + `CREATE TABLE tpl (
    cl1 INT,
    cl2 INT
)
PARTITION BY LIST (cl1) (
    PARTITION p0 VALUES IN (1,3,4,5),
    PARTITION p1 VALUES IN (2,6,7,8)
);`
    + Columns partition 
        + Range column partition 
        + List column partition 
    + Hash partition 
        + Hash partition 
        + Linear hash partition 
    + Key partition
    + Subpartitioning
    + Handle NULL in partition 
    + Manage partition 
        + Partition maintainance 
        + Rebuild partitions 
        + Optimize partitions 
        + Analyze partition 
        + Repair partitions
        + Check partition
        + Optain partition information : `show create table <table-name>`
    + Pruning partition 
        + 



### Docker 
+ Install Docker (locally)
+ Usinng docker-compose 
+ Using docker-swarm 
+ `docker images`
+ `docker run -p -d --name `
+ View log : `docker logs `
+ View docker container : `docker ps`
+ Manage the container 
    + `docker stop ...`
    + `docker start ...` 

### Messaging JMS - RabbitMQ
+ Fanout and Topic exchange 
+ Message Type: BytesMessage, MapMessage, ObjectMessage, StreamMessage, TextMesage 
+ Enable RabbitMQ plugin : `sudo rabbitmq-plugins enable rabbitmq_management`
+ Async/Sync RabbitTemplate 
+ Messaging type: Fanout, Header
+ Configuration file 
    + auth_
    + default_user
    + default_pass
    + default_permission
    + disk_free_limit
    + heartbeat
    + hipe_compile
    + log_level
    + tcp_listener
    + ssl_
    + vm_memory_
    + Runtime parameters
+ Clustering RabbitMQ and high availability 
+ Federation in RabbitMQ 
+ Clustering settings 
    + install federation plugin `rabbitmq-plugins enable rabbitmq_federation`
    + install management plugin `rabbitmq-plugins enable rabbitmq_federation_management`
    + Replicate data/states across all the nodes 
    + Create cluster 
    + Start each of server node : ` rabbitmq-server –detached`
    + Check cluster status from management plugin : rabbitmqctl cluster_status
    + Instance name / port 
+ Load balancing for queues 
    + Load balancing system 
        + TCP load balancer 
        + HAProxy 
+ Management RabbitMQ server 
    + Send / receive message 
    + JSON 
    + Purging queue 
    + Monitor queue length, message rate , connection
    + rabbitmqctl plugin 
    + Enable web plugin : rabbitmq-plugins enable rabbitmq_management
    + Rest API : `localhost:55672/api/overview` and `/api/queues`, /connections, /channels,/bindings,
    +  
+ Security in rabbitmq 
    + Access control 
    + SASL authentication 
    + SSL support 
+ Monitor RabbitMQ 
    + Command line tool 
    + Web plugins 
+ Available profiles 
    + fanout 
    + direct 
    + topic 


### Memcached 
+ Install Memcached (locally)
+ Config Memcache config : locally 
+ 





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
   
  
+ Install and run memcache server(local)
    + `brew installl memcache`
    + 
    
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