package com.project.blogforum.service.essearch;


import com.project.blogforum.domain.User;
import com.project.blogforum.search.ESUserRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class UserService {

//    @Autowired
//    private ESUserRepository esUserRepository;
//
//    public Iterable<User> findByDesc(String desc) {
//
//        QueryBuilder queryBuilder = QueryBuilders.matchQuery("desc", desc);
//        return esUserRepository.search(queryBuilder);
//    }

}