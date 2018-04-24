#!/usr/bin/env bash


# use pt-query-digest to analyze the general query log :
sudo pt-query-digest --type genlog /var/lib/mysql/db1.log   > general_query_digest


# process list : iteration run
pt-query-digest --processlist h=localhost  --iterations 10 --run-time 1m -u <user> -p<pass>


# Binary log
sudo mysqlbinlog /var/lib/mysql/binlog.000639 > binlog.00063
pt-query-digest --type binlog binlog.000639  > binlog_digest


# TCP dump
sudo tcpdump -s 65535 -x -nn -q -tttt -i any -c 1000 port 3306 > mysql.tcp.txt
pt-query-digest --type tcpdump mysql.tcp.txt > tcpdump_digest

# INDEX
# drop duplicate key
pt-duplicate-key-checker -u <user> -p<pass>

# index analysis
sudo pt-index-usage slow -u <user> -p<password> /var/lib/mysql/db1-slow.log > unused_indexes


# MANAGE LOG 
# Config the error log 
# Change the log location  -> edit the config file - > restart MySQL server 
sudo mkdir /var/log/mysql
sudo chown -R mysql:mysql /var/log/mysql
# Edit config file
sudo vi /etc/my.cnf
[mysqld]
log-error=/var/log/mysql/mysqld.log
# Restart the MySQL 
sudo systemctl restart mysql



# Show the query log file 
sudo cat /var/log/mysql/general_query_log

# Binary log 
mysqlbinlogpurge --master=dbadmin:<pass>@master:3306 --slaves=dbadmin:<pass>@slave1:3306,dbadmin:<pass>@slave2:3306


mysqlbinlogpurge --master=dbadmin:<pass>@master:3306 --slaves=dbadmin:<pass>@slave1:3306,dbadmin:<pass>@slave2:3306

# Latest binlog file replicated by all slaves: master-bin.000022
# Purging binary logs prior to 'master-bin.000023'

# Set the report host and report port and then resatart the server 
sudo vi /etc/my.cnf
[mysqld]
report-host     = slave1
report-port     = 3306

# Restart the server

# 