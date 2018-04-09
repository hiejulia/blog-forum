package com.project.blogforum.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.project.blogforum.domain.User user = userService.findUserByLogin(login);

        Collection<SimpleGrantedAuthority> grantedAuthorities = user.getAuthorities().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toCollection(ArrayList::new));

        return new User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}