package com.coderpwh.ktspact

import com.coderpwh.ktspact.entry.Student
import com.coderpwh.ktspact.repository.StudentRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.Aggregation.limit
import org.springframework.data.mongodb.core.aggregation.Aggregation.sort


/**
 * @author coderpwh
 * @date 2022/5/16 12:20 PM
 */
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    lateinit var studentRepository: StudentRepository
    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    @Test
    fun `test save students`() {
        var student = Student("lq", "java", "hn")
        student.personId = 2200L
        student.age = 22
        student.name = "xiaoming"
        studentRepository.deleteAll()
        for(i in 1..15) {
            student.personId+=1
            student.age+=1
            studentRepository.save(student)
        }
    }

    @Test
    fun `test find by name and age`() {
        var page = PageRequest.of(0, 3)
        var list =
            studentRepository.findByNameRegexAndAgeGreaterThanEqual("xiaoming", 17, page)
        list.forEach{
            println(it)
        }
    }
    @Test
    fun `test find by name and age 2`() {
        var page = PageRequest.of(0,5)
        var list = studentRepository.findByAgeIndividual("xiaoming",18,page)
        list.forEach(
            {
                println(it)
            }
        )
    }

    @Test
    fun `test delete in age`() {
        studentRepository.deleteByAgeIn(16,20)
        studentRepository.findAll().forEach {
            println(it)
        }
    }

    @Test
    fun `test sort by age`() {
        var newAggregation = Aggregation.newAggregation(Student::class.java, sort(Sort.Direction.DESC, "age"), limit(3))
        mongoTemplate.aggregate(newAggregation,Student::class.java).mappedResults.forEach(
            {
                println(it)
            }
        )
    }

    @Test
    fun `test total`() {
        var countDocuments = mongoTemplate.db.getCollection("student").countDocuments()
        println(countDocuments)
    }

    

}