package com.project.blogforum.repository.es;



import com.project.blogforum.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESPostRepository extends ElasticsearchRepository<Post, Long> {

    // Find post by author
    Page<Post> findByAuthor(String author, Pageable pageable);

    // Find post by title 
    List<Post> findByTitle(String title);

}
