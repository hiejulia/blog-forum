package com.project.blogforum.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groupuser")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "specialization")
    private String specialization;


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private List<User> users;

    @OneToMany
    @JoinColumn(name = "groupuser_id",referencedColumnName = "id")
    private List<User> userList;
}