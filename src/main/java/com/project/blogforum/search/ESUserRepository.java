package com.project.blogforum.search;

import com.project.blogforum.domain.Post;
import com.project.blogforum.domain.User;
import com.project.blogforum.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

//@Repository
public interface ESUserRepository extends ElasticsearchRepository<User, Long> {


    Page<User> findByEmal(String email, Pageable pageable);


    List<User> findByUsername(String u);


}