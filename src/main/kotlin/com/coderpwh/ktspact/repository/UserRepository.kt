package com.coderpwh.ktspact.repository

import com.coderpwh.ktspact.entry.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


/**
 * @author coderpwh
 * @date 2022/5/16 9:35 AM
 */
@Repository
interface UserRepository:CrudRepository<User,Long> {
    fun findUserByUserNameAndPassword(userName1:String,password1:String):User?
    fun findByUserNameLike(userName:String):List<User>?
    fun findByIncomeGreaterThan(inCome:Double):List<User>?
    fun findByUserNameContaining(userName:String):List<User>?
    @Transactional(rollbackFor = [Exception::class])
    fun deleteByUserNameAndEmail(userName:String,email:String):Int?
    fun save(user:User)

}