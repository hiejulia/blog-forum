package com.project.blogforum.service.essearch;


import com.project.blogforum.domain.Post;
import com.project.blogforum.dto.PostDTO;
import com.project.blogforum.event.NewPostEvent;
import com.project.blogforum.search.ESPostRepository;
import com.project.blogforum.util.PageableUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ESPostService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private ESPostRepository esPostRepository;


    public Page<PostDTO> getByNameLike(String name,int page, int size, String... sortAttributes) {
        Pageable pageable = PageableUtils.createPageable(page, size, sortAttributes);
        Page<PostDTO> pageResult = (Page<PostDTO>) esPostRepository.findByTitleContaining(name, pageable);
        return pageResult;
    }
    // Save post
    public PostDTO saveNewPost(PostDTO post){
        esPostRepository.save(post);
        // Publish event
        publisher.publishEvent(new NewPostEvent(this,post));
        return post;
    }

    public void update(Long id, Post resource) {
        PostDTO crusher = esPostRepository.findOne(id);
        if (crusher != null) {
            esPostRepository.save(crusher);
        }
    }
//
//    public Page<Entity> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
//        return repository.findAll(constructPageRequest(page, size, sortBy, sortOrder));
//    }
//
//
//    public Page<Entity> search(int page, int size, String sortBy, String sortOrder, Map<String, String[]> filters) {
//        QueryBuilder query = addFilters(filters);
//        return repository.search(query, constructPageRequest(page, size, sortBy, sortOrder));
//    }

    // Find all post
    public List<PostDTO> listAll() {
        List<PostDTO> posts = new ArrayList<>();
        esPostRepository.findAll().forEach(posts::add);
        return posts;
    }




}
