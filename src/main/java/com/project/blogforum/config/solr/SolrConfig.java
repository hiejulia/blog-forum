package com.project.blogforum.config.solr;


import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

//@Configuration
//@EnableSolrRepositories(basePackages = {"com.project.blogforum.solr"}, multicoreSupport = true)
public class SolrConfig {

//    @Value("${spring.data.solr.zk-host}")
//    private String zkHost;
//
//    @Bean
//    public CloudSolrClient solrClient() {
//        return new CloudSolrClient(zkHost);
//    }

}