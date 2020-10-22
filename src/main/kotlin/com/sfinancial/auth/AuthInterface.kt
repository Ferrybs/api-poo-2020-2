package com.sfinancial.auth

import com.sfinancial.login.LoginInterface

interface AuthInterface {
    fun sign(loginInterface: LoginInterface): String
    fun rSecret(): String
    fun rIssuer(): String
}