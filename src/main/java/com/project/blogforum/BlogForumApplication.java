package com.project.blogforum;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSwagger
@EnableElasticsearchRepositories(basePackages = "com.project.blogforum.search")
@EnableJpaRepositories(basePackages = {"com.project.blogforum.repository"})
@EnableAsync
public class BlogForumApplication {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

//	@Value("${Connect.database}")
	private String database = "forumblog";

	@Bean(initMethod = "migrate")
	public Flyway flyway() {
		/**
		 As flyway Db need url seperetaly that is why we extracting only
		 url from  given string
		 */
		String urlWithoutDatabaseName=
				url.substring(0,url.lastIndexOf("/"));
		Flyway flyway = new Flyway();
		flyway.setDataSource(urlWithoutDatabaseName, userName,
				password); // init datasource
		flyway.setSchemas(database); //set schema
		flyway.setBaselineOnMigrate(true);
		return flyway;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogForumApplication.class, args);
	}
}
