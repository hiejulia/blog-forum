package com.project.blogforum.search;

import com.project.blogforum.domain.Post;
import com.project.blogforum.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/*import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;*/
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ESPostRepository extends ElasticsearchRepository<PostDTO, Long> {

//
//
    // Find post by author
    Page<Post> findByAuthor(String author, Pageable pageable);

    // Find post by title
    List<Post> findByTitle(String title);

    // Find by tag name
    List<Post> findByTagList(String tag);

}