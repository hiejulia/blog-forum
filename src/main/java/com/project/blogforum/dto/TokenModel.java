package com.project.blogforum.dto;

import java.io.Serializable;

public class TokenModel implements Serializable {
    private String token;

    public TokenModel() {
    }

    public TokenModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
