package com.coderpwh.ktspact.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


/**
 * @author coderpwh
 * @date 2022/5/16 3:21 PM
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig:WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.formLogin()
            .permitAll()
            .and()
            .authorizeRequests()
            .antMatchers("/**")
            .authenticated()
            .and()
            .csrf()
            .disable()
    }
}