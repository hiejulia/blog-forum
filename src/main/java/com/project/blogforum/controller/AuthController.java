package com.project.blogforum.controller;
import com.project.blogforum.config.security.SecurityProvider;
import com.project.blogforum.domain.User;
import com.project.blogforum.dto.LoginDTO;
import com.project.blogforum.dto.TokenModel;
import com.project.blogforum.dto.UserDTO;
import com.project.blogforum.service.impl.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/v1/api")
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    SecurityProvider provider;
    /**
     * AUTHENTICATE
     */

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginDTO loginDTO,
                                          HttpServletRequest request) throws AuthenticationException {
        if (userService.findUserByLogin(loginDTO.getLogin()) != null) {
            String token = Jwts.builder().setSubject(loginDTO.getLogin()).
                    signWith(SignatureAlgorithm.HS512, provider.getTokenKey()).compact();

            return new ResponseEntity<>(new TokenModel(token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * USER
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> currentUser(HttpServletRequest request) throws Exception {
        try {
            String subject = Jwts.parser().setSigningKey(provider.getTokenKey())
                    .parseClaimsJws(request.getHeader("Rest-Token"))
                    .getBody().getSubject();

            UserDTO response = new UserDTO();

            User currentUser = userService.findUserByLogin(subject);

            //FIXME fix authority json mapping
            //response.setAuthorities(currentUser.getAuthorities());
            response.setEmail(currentUser.getEmail());
            response.setLogin(currentUser.getLogin());
            response.setId(currentUser.getId());
            response.setUsername(currentUser.getUsername());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    /**
     * LOG OUT
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        try {
            String subject = Jwts.parser().setSigningKey(provider.getTokenKey())
                    .parseClaimsJws(request.getHeader("Rest-Token"))
                    .getBody().getSubject();

            //TODO: fix it if we want session, if not logout mech will be on client side
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }




}
