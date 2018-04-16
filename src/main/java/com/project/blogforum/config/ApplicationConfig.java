package com.project.blogforum.config;


import com.project.blogforum.audit.SecurityAuditorAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
//@EnableConfigurationProperties(ConnectionSettings.class)
@EnableJpaAuditing
public class ApplicationConfig {
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Autowired
    public Environment env;

    public void setEnv(Environment env) {
        this.env = env;
    }

//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return (container -> {
//            container.setPort(env.getProperty("tomcat.port", Integer.class));
//            container.setContextPath(env.getProperty("tomcat.context"));
//        });
//    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dinesh.springdatajpa"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public AuditorAware<String> getSecurityAuditAware(){
        return new SecurityAuditorAware();
    }

}