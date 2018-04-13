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
    Page<PostDTO> findByAuthor(String author, Pageable pageable);

    // Find post by title
    List<PostDTO> findByTitle(String title);

    // Find by tag name
    List<PostDTO> findByTagList(String tag);

    // Find by category like
    List<PostDTO> findByCategoryLike(String c);

    // Find by title and author
    List<PostDTO> findByTitleAndAuthor(String t, String a);

    List<PostDTO> findByAuthorNot(String a);

}