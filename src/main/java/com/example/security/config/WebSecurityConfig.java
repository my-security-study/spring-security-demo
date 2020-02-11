package com.example.security.config;

import com.example.security.handler.DefaultAuthenticationSuccessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author chenling
 * @date 2020/2/10 15:03
 * @since V1.0.0
 */
@EnableWebSecurity(debug = true)
@Slf4j
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DefaultAuthenticationSuccessHandler defaultAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/home","/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .successHandler(defaultAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("chenling").password(passwordEncoder().encode("123456")).roles("USER");
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
