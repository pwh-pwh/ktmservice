package com.coderpwh.ktspact.entry

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.Id


/**
 * @author coderpwh
 * @date 2022/5/16 12:07 PM
 */
open class Person {
    @Id
    var personId:Long=0L
    var name:String=""
    var address:String=""
    var age:Int = 0
    var date:Date = Date()
    override fun toString(): String {
        return "Person(personId=$personId, name='$name', address='$address', age=$age, date=$date)"
    }

}
@Document("student")
data class Student(
    val likeSport:String,
    val likeBook:String,
    val school:String
):Person() {
    override fun toString(): String {
        return super.toString()+"Student(likeSport='$likeSport', likeBook='$likeBook', school='$school')"
    }
}