package com.project.blogforum.dto;
import com.project.blogforum.domain.Comment;
import com.project.blogforum.domain.Tag;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.List;

@Document(indexName = "posts", type = "posts", shards = 1)
@Data
public class PostDTO implements Serializable {
    private Long id;
    private String title;
    private String subtitle;
    private String content;
    private String date;
    private String author;
    private String category;
    private List<Comment> commentList;
    private List<Tag> tagList;


}
