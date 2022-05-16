package com.coderpwh.ktspact.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * @author coderpwh
 * @date 2022/5/16 10:12 AM
 */
@Configuration
class QuerydslConfig {
    @Autowired
    @PersistenceContext
    lateinit var entityManager:EntityManager
    @Bean
    fun queryFactory():JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }
}