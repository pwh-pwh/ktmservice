package com.coderpwh.ktspact.security

import com.coderpwh.ktspact.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.stereotype.Component


/**
 * @author coderpwh
 * @date 2022/5/16 3:31 PM
 */
@Component
class CustomAuthProvider:AuthenticationProvider {
    @Autowired
    lateinit var userRepository: UserRepository

    val auth = mapOf<String,String>(
        "root" to "ROLE_ADMIN","user1" to "ROLE_USER","user" to "ROLE_USER"
    )


    override fun authenticate(authentication: Authentication): Authentication? {
        val userName = authentication.name
        val password = authentication.credentials.toString()
        var user = userRepository.findByUserName(userName)
        println("start auth")
        if(user?.password.equals(password)){
            var authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(auth[user!!.userName])
            println("success auth")
            return UsernamePasswordAuthenticationToken(user,password,authorities)
        }
        return null
    }

    override fun supports(authentication: Class<*>?) = true

}