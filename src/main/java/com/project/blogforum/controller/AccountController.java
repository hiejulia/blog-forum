package com.project.blogforum.controller;


import com.project.blogforum.repository.UserRepository;
import com.project.blogforum.service.impl.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/v1/api/users/account")
public class AccountController {

    public static final int PASSWORD_MIN_LENGTH = 6;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    /**
     * GET  /authenticate -> check if the user is authenticated, and return its login.
     */
    @RequestMapping(value = "/authenticate",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    /**
     * POST  /change_password -> changes the current user's password
     */
    @RequestMapping(value = "/{id}/changepassword",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changePassword(@RequestBody String password, @PathVariable("id")Long id) {
        if (StringUtils.isEmpty(password) || password.length() < PASSWORD_MIN_LENGTH) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
        }
        userService.changePassword(password,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/account",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getAccount() {
//        return userRepository.findOneByUsername(SecurityUtils.getCurrentUserName())
//                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
//    }


}