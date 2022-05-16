package com.coderpwh.ktspact.entry

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id



/**
 * @author coderpwh
 * @date 2022/5/15 11:37 PM
 */

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val userName: String,
    val password: String,
    val email: String,
    val age: Int,
    val height: Double,
    val address: String,
    val education: EducationLevel,
    val income: Double
) {
    constructor() : this(0,"","","",-1,0.0,"",
    EducationLevel.BENKE,0.0) {

    }
}

enum class EducationLevel {
    XIAOXUE, GAOZHONG, BENKE, YANJIUSHENG, BOSHI
}
