package com.project.blogforum.dto;
import com.project.blogforum.domain.Comment;
import com.project.blogforum.domain.Tag;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;
import java.util.Date;
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

    @Field(type = FieldType.Date, index = FieldIndex.not_analyzed, store = true,
            format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Date createdAt;
    
    @Field(type = FieldType.Date, index = FieldIndex.not_analyzed, store = true,
            format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Date lastModifiedDate;

}
