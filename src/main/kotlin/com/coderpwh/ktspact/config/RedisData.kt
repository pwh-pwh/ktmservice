package com.coderpwh.ktspact.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.data.redis.core.RedisTemplate
import java.time.Duration
import java.util.concurrent.TimeUnit


/**
 * @author coderpwh
 * @date 2022/5/15 8:11 PM
 */
@SpringBootConfiguration
class RedisData {
    @Autowired
    private lateinit var redisTemplate: RedisTemplate<String, String>
    private final inline fun addExpireTime(key:String, expireSecond:Long) {
        redisTemplate.expire(key,expireSecond,TimeUnit.SECONDS)
    }

    //设置不带过期时间
    fun saveString(key:String,value:String) {
        redisTemplate.opsForValue().set(key,value)
    }
    //带过期时间
    fun saveStringWithExpire(key:String,value:String,expireSecond:Long) {
        redisTemplate.opsForValue().set(key,value, Duration.ofSeconds(expireSecond))
    }
    //获取值
    fun getString(key:String):String? {
        return redisTemplate.opsForValue().get(key)
    }

    //保存字符串列表
    fun saveList(key:String,values:List<String>) {
        redisTemplate.opsForList().leftPushAll(key,values)
    }

    fun saveListWithExpire(key:String,values:List<String>,expireSecond:Long) {
        saveList(key,values)
        addExpireTime(key,expireSecond)
    }

    fun getListValues(key:String,start:Long,end:Long):List<String> {
        if (start>end) {
            return emptyList()
        }
        return redisTemplate.opsForList().range(key, start, end)?: emptyList()
    }

    fun saveSet(key:String,values:Array<String>) {
        redisTemplate.opsForSet().add(key, *values)
    }

    fun saveSetWithExpire(key:String,values:Array<String>,expireSecond:Long) {
        redisTemplate.opsForSet().add(key,*values)
        addExpireTime(key,expireSecond)
    }

    fun getSetValues(key:String): Set<String> {
        return redisTemplate.opsForSet().members(key)!!
    }

    fun getDiffSet(key1:String,key2:String): Set<String> {
        return redisTemplate.opsForSet().difference(key1,key2)?: emptySet()
    }

    fun saveZSet(key:String,values:Array<Pair<String,Double>>) {
        values.forEach {
            v ->
            redisTemplate.opsForZSet().add(key,v.first,v.second)
        }
    }
    fun saveZSetWithExpire(key:String,values:Array<Pair<String,Double>>,expireSecond:Long) {
        saveZSet(key,values)
        addExpireTime(key,expireSecond)
    }

    fun getZSetValuesByScore(key:String,minScore:Double,maxScore:Double) :
    Set<String>?{
        return redisTemplate.opsForZSet().rangeByScore(key,minScore,maxScore)
    }

    fun saveHash(key:String,values:Map<String,String>) {
        redisTemplate.opsForHash<String,String>().putAll(key,values)
    }

    fun saveHashWithExpire(key:String,values:Map<String,String>,expireSecond:Long) {
        saveHash(key,values)
        addExpireTime(key,expireSecond)
    }

    fun getHashValues(key:String):List<String>? {
        return redisTemplate.opsForHash<String,String>().values(key)
    }



}