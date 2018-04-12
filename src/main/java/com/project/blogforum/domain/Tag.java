package com.project.blogforum.domain;

import lombok.Data;
//import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tag")
//@Data

public class Tag implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, unique = true)
    private String name;

    @Column(name = "post_id")
    private Long postId;

//    @Field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Field
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Tag(String name, Long postId) {
        this.name = name;
        this.postId = postId;
    }
}
