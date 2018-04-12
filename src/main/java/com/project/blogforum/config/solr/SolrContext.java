package com.project.blogforum.config.solr;

//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.impl.HttpSolrClient;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
//import org.springframework.data.solr.core.SolrTemplate;
//import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import javax.annotation.Resource;


//@Configuration
//@EnableSolrRepositories(basePackages = { "com.project.blogforum" }, multicoreSupport = true)
public class SolrContext {
//
//    @Value("${spring.data.solr.host}")
//    private String url;
//
//    @Bean
//    public SolrClient solrClient() {
//        return new HttpSolrClient(url);
//    }
//
//    @Bean
//    public SolrTemplate solrTemplate() throws Exception {
//        SolrTemplate solrTemplate =  new SolrTemplate(solrClient());
////		solrTemplate.setSolrConverter(solrConverter);
//        return solrTemplate;
//    }




}