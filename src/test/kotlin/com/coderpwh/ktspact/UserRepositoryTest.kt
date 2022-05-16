package com.coderpwh.ktspact

import com.coderpwh.ktspact.entry.EducationLevel
import com.coderpwh.ktspact.entry.User
import com.coderpwh.ktspact.repository.UserRepository
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


/**
 * @author coderpwh
 * @date 2022/5/16 9:43 AM
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@ExtendWith(SpringExtension::class)
class UserRepositoryTest {
    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    @Order(1)
    fun `test save user`() {
        userRepository.deleteAll()
        var users = arrayOf(
            User(1,"aaa","bbb","ccc",20,179.0,"beijing",EducationLevel.BENKE,110000.0),
            User(2,"aaa1","bbb1","ccc1",20,179.0,"beijing",EducationLevel.BENKE,110000.0),
        )
        userRepository.saveAll(users.asList().asIterable())
        userRepository.findAll().forEach{
            println(it)
        }
    }

    @Test
    @Order(1)
    fun `test find by user and password`() {
        println(userRepository.findUserByUserNameAndPassword("aaa", "bbb"))
    }
}