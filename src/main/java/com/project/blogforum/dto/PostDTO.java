package com.project.blogforum.dto;
import com.project.blogforum.domain.Comment;
import com.project.blogforum.domain.Tag;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

@Document(indexName = "posts", type = "posts", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
public class PostDTO implements Serializable {
    private Long id;
    @Field(type = FieldType.String)
    private String title;
    private String subtitle;
    private String content;
    private String date;
    private String author;
    private String category;
    @Field(type = FieldType.Object)
    private List<Comment> commentList;
    @Field(type = FieldType.Nested)
    private List<Tag> tagList;


}
