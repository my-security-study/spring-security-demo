package com.example.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenling
 * @date 2020/2/10 17:54
 * @since V1.0.0
 */
@Component
@Slf4j
public class DefaultAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        RequestCache cache = new HttpSessionRequestCache();
        SavedRequest savedRequest = cache.getRequest(httpServletRequest, httpServletResponse);
        String url = savedRequest.getRedirectUrl();
        log.info("请求前的URL :{}",url);
        httpServletResponse.sendRedirect(url);
    }
}
