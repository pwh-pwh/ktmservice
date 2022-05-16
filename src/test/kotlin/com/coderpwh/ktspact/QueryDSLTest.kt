package com.coderpwh.ktspact

import com.coderpwh.ktspact.entry.QUser
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


/**
 * @author coderpwh
 * @date 2022/5/16 10:05 AM
 */
@SpringBootTest
class QueryDSLTest {
    @Autowired
    lateinit var queryFactory:JPAQueryFactory
    @Test
    fun `test find user by username and password`() {
        var user = QUser.user
        var predicate = user.userName.eq("aaa").and(user.password.eq("bbb"))
        val r = queryFactory.selectFrom(user).where(predicate).fetchOne()
        println(r)
    }
}