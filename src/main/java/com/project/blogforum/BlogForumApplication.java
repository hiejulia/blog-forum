package com.project.blogforum;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSwagger
public class BlogForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogForumApplication.class, args);
	}
}
