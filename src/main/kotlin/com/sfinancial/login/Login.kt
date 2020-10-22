package com.sfinancial.login

import io.ktor.auth.*


class Login(
        private val username: String? = null,
        private val password: String? = null
): Principal, LoginInterface{

    override fun getUsername(): String? {
        return username
    }
    override fun getPassword(): String? {
        return password
    }

}