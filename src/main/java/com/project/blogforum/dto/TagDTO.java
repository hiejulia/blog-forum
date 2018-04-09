package com.project.blogforum.dto;

import java.io.Serializable;

public class TagDTO implements Serializable {

    private Long id;
    private String name;
    private Integer postId;

    public TagDTO(Long id, String name, Integer postId) {
        this.id = id;
        this.name = name;
        this.postId = postId;
    }
    public TagDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postId=" + postId +
                '}';
    }
}



