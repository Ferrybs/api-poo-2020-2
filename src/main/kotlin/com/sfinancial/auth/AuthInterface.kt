package com.sfinancial.auth

interface AuthInterface {
    fun sign(pass: String): String
    fun rSecret(): String
}