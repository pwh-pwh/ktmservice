package com.coderpwh.ktspact.repository

import com.coderpwh.ktspact.entry.Student
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.DeleteQuery
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query


/**
 * @author coderpwh
 * @date 2022/5/16 12:11 PM
 */

interface StudentRepository: MongoRepository<Student,Long> {
    fun findByPersonId(personId:Long):Student?
    fun findByNameRegexAndAgeGreaterThanEqual(name:String,age:Int,pageable:Pageable): Page<Student>
    @DeleteQuery(value = "{\"age\":{\"\$gte\":?0,\"\$lte\":?1}}")
    fun deleteByAgeIn(a1:Int,a2:Int)
    @Query(value = "{\"name\":{\"\$regex\":?0},\"age\":{\"\$gte\":?1}}")
    fun findByAgeIndividual(name: String ,age: Int, pageable: Pageable): Page<Student>
}