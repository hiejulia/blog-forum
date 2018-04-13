package com.project.blogforum.controller.ES;


import com.project.blogforum.domain.User;
import com.project.blogforum.search.ESUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/api/es/users")
public class ESUserController {
    @Autowired
    private ESUserRepository esUserRepository;

    /**
     * GET  /users -> get all users.
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAll() {
        return esUserRepository.findAll();
    }

    @RequestMapping(value = "/{username}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUser(@PathVariable String username) {
        if(esUserRepository.findByUsername(username) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(esUserRepository.findByUsername(username), HttpStatus.OK);
    }

    /**
     * SEARCH  /_search/users/:query -> search for the User corresponding
     * to the query.
     */
//    @RequestMapping(value = "/_search/{query}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> search(@PathVariable String query) {
//        return StreamSupport
//                .stream(esUserRepository.search(queryString(query)).spliterator(), false)
//                .collect(Collectors.toList());
//    }

}
