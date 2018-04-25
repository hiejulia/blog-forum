package com.project.blogforum.search;

import com.project.blogforum.domain.Post;
import com.project.blogforum.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ESPostRepository extends ElasticsearchRepository<PostDTO, Long> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Post> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);

    Page<PostDTO> findByAuthor(String author, Pageable pageable);

    List<PostDTO> findByTitle(String title);

    List<PostDTO> findByTagList(String tag);

    // Find by category like
//    List<PostDTO> findByCategoryLike(String c);

    // Find by title and author
    List<PostDTO> findByTitleAndAuthor(String t, String a);

    /*List<PostDTO> findByAuthorNot(String a);*/


    public Page<PostDTO> findByTitleContaining(String name, Pageable pageable);

//    public Page<PostDTO> findByRatingBetween(Double beginning, Double end, Pageable pageable);




}