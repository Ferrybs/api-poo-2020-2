package com.sfinancial.config.jwtConfig


interface JwtConfigInterface {
    fun getSecretJwt():String
    fun getIssuer(): String
}