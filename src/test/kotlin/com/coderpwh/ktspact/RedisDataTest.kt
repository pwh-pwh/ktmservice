package com.coderpwh.ktspact

import com.coderpwh.ktspact.config.RedisData
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert


/**
 * @author coderpwh
 * @date 2022/5/15 9:05 PM
 */
@SpringBootTest
class RedisDataTest {
    @Autowired
    lateinit var redisData: RedisData
    @Test
    fun `save redis key value with expire time`() {

        runBlocking {
            redisData.saveStringWithExpire("aaa1","avvv",2L)
            delay(2200)
        }
        var sr = redisData.getString("aaa1")
        Assert.isNull(sr,"no success")
    }


}