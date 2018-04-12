package com.project.blogforum.controller;


import java.util.List;


import com.project.blogforum.domain.Contact;
import com.project.blogforum.domain.User;
import com.project.blogforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/v1/api/rest/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getCustomers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}/contacts", method = RequestMethod.GET)
    public List<Contact> getCustomerContacts(@PathVariable("id") Long id) {
        return userRepository.findById(id).getContacts();
    }
}