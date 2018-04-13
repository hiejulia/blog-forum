package com.project.blogforum.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(indexName = "users", type = "users", shards = 1)
@Entity
@Data
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
    @Column(name = "id",insertable = false,updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50)
    @NotEmpty
    private String username;

    @Column(name = "email", length = 50)
    @NotEmpty
    @Email
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

  // Add : User Ranking
  @OneToMany
  @JoinColumn
  private List<Ranking> rankings;
  // group

    // add contact

    @JsonIgnore
    @OneToMany(mappedBy ="user")
    private List<Contact> contacts;


}
