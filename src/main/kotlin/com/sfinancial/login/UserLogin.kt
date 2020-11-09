package com.sfinancial.login

import com.fasterxml.jackson.annotation.JsonAutoDetect
import io.ktor.auth.*

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class UserLogin(
        private val username: String? = null,
        private val password: String? = null
): Principal, LoginInterface{

    override fun getUsername(): String? {
        return username
    }
    override fun getPassword(): String? {
        return password
    }

    override fun verifier(): Boolean {
        val hasNull =listOf(
                username,
                password,
        ).any { it == null }
        return !hasNull
    }

}