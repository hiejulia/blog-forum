package com.project.blogforum.config.security;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Component;

import java.security.Key;
@Component
public class SecurityProvider {

    private Key key;

    public SecurityProvider() {
        key = MacProvider.generateKey();
    }

    public SecurityProvider(Key key) {
        this.key = key;
    }

    public Key getTokenKey() {
        return key;
    }
}