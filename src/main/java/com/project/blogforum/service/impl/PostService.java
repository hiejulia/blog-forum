package com.project.blogforum.service.impl;
import com.project.blogforum.domain.Post;
import com.project.blogforum.dto.PostDTO;
import com.project.blogforum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post findOnePostById(Long id) {
        return postRepository.findOnePostById(id);
    }

    public void save(Post post) {
        postRepository.save(post);
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
}