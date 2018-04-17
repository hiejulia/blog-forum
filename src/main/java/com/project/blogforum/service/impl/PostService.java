package com.project.blogforum.service.impl;
import com.project.blogforum.domain.Post;
import com.project.blogforum.dto.PostDTO;
import com.project.blogforum.repository.PostRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PostService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PostRepository postRepository;


    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;

//    @Autowired
//    private MessageConverter messageConverter;


    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post findOnePostById(Long id) {
        return postRepository.findOnePostById(id);
    }

    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    public void deletePostById(Long id) {
        postRepository.delete(id);
    }

    public void updateContentById(PostDTO postDTO) {
        postRepository.updateContentById(postDTO.getContent(), postDTO.getId());
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

    // Send post message
    final String queuePost = "postQueue";

    public void sendPostMessage(Long productId) {
//        this.rabbitTemplate.setMessageConverter(messageConverter);
        Map<String, Long> actionmap = new HashMap<>();
        actionmap.put("id", productId);
        rabbitTemplate.convertAndSend(queuePost, actionmap);
    }
}