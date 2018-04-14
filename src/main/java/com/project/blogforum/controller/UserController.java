package com.project.blogforum.controller;


import java.util.List;
import java.util.UUID;


import com.project.blogforum.domain.Contact;
import com.project.blogforum.domain.User;
import com.project.blogforum.repository.UserRepository;
import com.project.blogforum.search.ESUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController(value = "/v1/api/rest/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ESUserRepository esUserRepository;

    @GetMapping
    public List<User> getCustomers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}/contacts", method = RequestMethod.GET)
    public List<Contact> getCustomerContacts(@PathVariable("id") Long id) {
        return userRepository.findById(id).getContacts();
    }
    // Create new user -> save to ElasticSearch 
    @RequestMapping( method = RequestMethod.POST)
    public User saveUser(@Valid @RequestBody User user) {
        esUserRepository.save(user);
        return user;
    }

    // Search for user

}