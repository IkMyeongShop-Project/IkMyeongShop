package com.study.ikmyeongshopteam4.config;

import com.study.ikmyeongshopteam4.security.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()
                .antMatchers("/account/mypage","/index","/checkout")
                .authenticated()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
                .antMatchers("/admin/**","/api/admin/**")
                .permitAll()
                //인증을 거쳐라
                .anyRequest()
                .permitAll()
                //권한을 허용하라
                .and()
                //그리고
                .formLogin()
                .usernameParameter("email")
                //폼로그인에 대한 설정
                .loginPage("/account/login")
                //페이지주소.
                .loginProcessingUrl("/account/login")
                .failureHandler(new AuthFailureHandler())
                //로그인 서비스 포스트요청
                .defaultSuccessUrl("/index");



    }

}
