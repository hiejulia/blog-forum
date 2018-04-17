package com.project.blogforum;

import com.mangofactory.swagger.plugin.EnableSwagger;
//import org.flywaydb.core.Flyway;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.traansport.client.PreBuiltTransportClient;
//import org.apache.http.auth.Credentials;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.impl.HttpSolrClient;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
import com.project.blogforum.messaging.receiver.Receiver;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.solr.core.SolrTemplate;
//import org.springframework.data.solr.repository.config.EnableSolrRepositories;
//import org.springframework.data.solr.server.SolrClientFactory;
//import org.springframework.data.solr.server.support.HttpSolrClientFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.net.InetAddress;

@SpringBootApplication
@EnableScheduling
@EnableSwagger
//@EnableElasticsearchRepositories(basePackages = "com.project.blogforum.search")
//@EnableSolrRepositories("com.project.blogforum.solr")
@EnableJpaRepositories(basePackages = {"com.project.blogforum.repository"})
@EnableAsync
@ComponentScan
@EnableCaching
public class BlogForumApplication {
	// Topic exchange
	static final String topicExchangeName = "topic1"; // topic exchange

	static final String getTopicExchangeNamePost = "postTopic";

	static final String queueName = "test1";

	static final String queueNamePost = "postQueue";

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

//	@Value("${Connect.database}")
	private String database = "forumblog";

	// Config Flyway
	@Bean(initMethod = "migrate")
	public Flyway flyway() {
		/**
		 As flyway Db need url seperetaly that is why we extracting only
		 url from  given string
		 */
		String urlWithoutDatabaseName=
				url.substring(0,url.lastIndexOf("/"));
		Flyway flyway = new Flyway();
		// set datasource
		flyway.setDataSource(urlWithoutDatabaseName, userName,
				password); // init datasource
		flyway.setSchemas(database); //set schema
		flyway.migrate();
		flyway.setBaselineOnMigrate(true);
		System.out.print("=========== FLYWAY==========");
		return flyway;
	}


	// Config Solr server
//	@Bean
//	public HttpSolrServer solrServer1() {
//		return new HttpSolrServer("http://localhost:8983/solr");
//	}
//
//	@Bean
//	SolrClient solrServer() {
//		return new HttpSolrClient("http://localhost:8983/solr");
//	}
//
//	@Bean
//	public SolrTemplate solrTemplate(HttpSolrServer server) throws Exception {
//		return new SolrTemplate(server);
//	}

//	@Bean
//	SolrTemplate solrTemplate() {
//		return new SolrTemplate(solrServerFactory());
//	}
//
//	@Bean
//	SolrClientFactory solrServerFactory() {
//
//		Credentials credentials = new UsernamePasswordCredentials("solr", "SolrRocks");
//		return new HttpSolrClientFactory(solrServer(), "forum_core", credentials , "BASIC");
//	}




	@Bean
	Queue queueNewPost() {
		return new Queue(queueNamePost, false);
	}

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}


	@Bean
	TopicExchange exchange() {
		return new TopicExchange(getTopicExchangeNamePost);
	}

	@Bean
	Binding bindingNewPost(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("create.post.#");
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}


	public static void main(String[] args) {
		SpringApplication.run(BlogForumApplication.class, args);


	}
}
