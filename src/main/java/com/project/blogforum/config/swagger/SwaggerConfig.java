//package com.project.blogforum.config.swagger;
//
//
//import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
//import com.mangofactory.swagger.models.dto.ApiInfo;
//import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
//import com.mangofactory.swagger.plugin.EnableSwagger;
//import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableSwagger
//public class SwaggerConfig {
//    @Autowired
//    private SpringSwaggerConfig springSwaggerConfig;
//
//    @Bean
//    public SwaggerSpringMvcPlugin configureSwagger() {
//        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
//
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("BlogForum")
//                .description("BlogForum Spring boot project ")
//                .termsOfServiceUrl("http://example.com/terms-of-service")
//                .contact("info@example.com")
//                .license("MIT License")
//                .licenseUrl("http://opensource.org/licenses/MIT")
//                .build();
//
//        swaggerSpringMvcPlugin.apiInfo(apiInfo)
//                .apiVersion("1.0");
//
//        return swaggerSpringMvcPlugin;
//    }
//}
