package com.project.blogforum.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "uc_user_username",columnNames = {"username"}),
                @UniqueConstraint(name = "uc_user_email",columnNames = {"email"}),
                @UniqueConstraint(name = "uc_user_login",columnNames = {"login"}),

        }
)
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50)
    @NotEmpty
    private String username;

    @Column(name = "email", length = 50)
    @NotEmpty
    private String email;

    @Column(name = "login", length = 50)
    @NotEmpty
    private String login;

    @Column(name = "password")
    @NotEmpty
    @Size(min = 6, max = 12)
    @JsonIgnore
    private String password;
    // admin
    @Column(name="admin", columnDefinition="char(3)")
    @Type(type="yes_no")
    @NotEmpty
    private boolean admin;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")}
    )
    private List<Authority> authorities;

    public User() {
    }

    public User(String nickname, String email, String login, String password, List<Authority> authorities) {
        this.username = username;
        this.email = email;
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, login, password, authorities);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + username + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }


}
