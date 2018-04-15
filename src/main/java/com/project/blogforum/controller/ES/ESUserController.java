package com.project.blogforum.controller.ES;


import com.project.blogforum.domain.User;
import com.project.blogforum.search.ESUserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/api/es/users")
@Api(value = "User elasticsearch controller", description = "User API with Elasticsearch")
public class ESUserController {
    @Autowired
    private ESUserRepository esUserRepository;

//    @Autowired
//    private HttpServletRequest request;

    /**
     * GET  /users -> get all users.
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
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

    // Count the number of User
    @RequestMapping(method = RequestMethod.GET, value = "/count")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long count() {
        return esUserRepository.count();
    }



}
