package com.example.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @author chenling
 * @date 2020/2/11 11:26
 * @since V1.0.0
 */
@Service
public class MyAuthenticationProvider implements AuthenticationProvider {




    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
