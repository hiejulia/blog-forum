package com.project.blogforum.audit;


import org.springframework.data.domain.AuditorAware;

public class SecurityAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "LoggedInUser";
    }

}