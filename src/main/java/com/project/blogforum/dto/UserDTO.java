package com.project.blogforum.dto;

import com.project.blogforum.domain.Authority;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String login;
    private List<Authority> authorities;

    public UserDTO() {
    }

    public UserDTO(String username, String email, String login,List<Authority> authorities) {
        this.username = username;
        this.email = email;
        this.login = login;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
