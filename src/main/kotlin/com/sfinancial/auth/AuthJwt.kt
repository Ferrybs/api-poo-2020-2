package com.sfinancial.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.sfinancial.login.LoginInterface

class AuthJwt(
        private val secret: String,
        private val issuer: String
): AuthInterface{
    private val algorithm = Algorithm.HMAC256(secret)
    val verifier = JWT.require(algorithm).build()

    override fun sign(loginInterface: LoginInterface):String{
        val token =JWT.create().withSubject("Authentication")
                .withIssuer(issuer)
                .withClaim("username",loginInterface.getUsername())
                .withClaim("password",loginInterface.getPassword())
                .sign(algorithm)
        return token.toString()
    }
    override fun rSecret(): String {
        return secret
    }

    override fun rIssuer(): String {
        return issuer
    }


}