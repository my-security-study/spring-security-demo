package com.example.security.filter;

import com.example.security.handler.DefaultAuthenticationFailureHandler;
import com.example.security.handler.DefaultAuthenticationSuccessHandler;
import com.example.security.manager.UserPasswordProviderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenling
 * @date 2020/2/11 11:12
 * @since V1.0.0
 */
@Service
public class MyAbstractAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {


    @Autowired
    private DefaultAuthenticationSuccessHandler defaultAuthenticationSuccessHandler;

    @Autowired
    private DefaultAuthenticationFailureHandler defaultAuthenticationFailureHandler;

    @Autowired
    private UserPasswordProviderManager userPasswordProviderManager;

    public MyAbstractAuthenticationProcessingFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
        super.setAuthenticationManager(userPasswordProviderManager);
        super.setAuthenticationSuccessHandler(defaultAuthenticationSuccessHandler);
        super.setAuthenticationFailureHandler(defaultAuthenticationFailureHandler);
    }

    protected MyAbstractAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
