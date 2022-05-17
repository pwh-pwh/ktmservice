package com.coderpwh.ktspact.config

import org.springframework.context.annotation.*
import org.springframework.security.config.annotation.method.configuration.*
import org.springframework.security.config.annotation.web.builders.*
import org.springframework.security.config.annotation.web.configuration.*


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
            .antMatchers("/admin/**")
            .authenticated()
            .and()
            .csrf()
            .disable()
    }
}