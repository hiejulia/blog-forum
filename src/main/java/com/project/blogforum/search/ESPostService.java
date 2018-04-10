package com.project.blogforum.search;



import com.project.blogforum.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ESPostService{

    @Autowired
    private ESPostRepository esPostRepository;



    public Post save(Post book) {
        return esPostRepository.save(book);
    }


    public void delete(Post book) {
        esPostRepository.delete(book);
    }


    public Post findOne(Long id) {
        return esPostRepository.findOne(id);
    }


    public Iterable<Post> findAll() {
        return esPostRepository.findAll();
    }


    public Page<Post> findByAuthor(String author, PageRequest pageRequest) {
        return esPostRepository.findByAuthor(author, pageRequest);
    }


    public List<Post> findByTitle(String title) {
        return esPostRepository.findByTitle(title);
    }

}