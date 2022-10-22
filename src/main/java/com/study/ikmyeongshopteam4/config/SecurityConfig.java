package com.study.ikmyeongshopteam4.config;

import com.study.ikmyeongshopteam4.security.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()
                .antMatchers("/account/mypage","/index")
                .authenticated()
                .antMatchers("/admin/**","/api/admin/**")
                .permitAll()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .usernameParameter("username")
                .loginPage("/account/login")
                .loginProcessingUrl("/account/login")
                .failureHandler(new AuthFailureHandler())
                .defaultSuccessUrl("/index");
    }
}
