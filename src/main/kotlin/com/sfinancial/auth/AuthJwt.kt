package com.sfinancial.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

class AuthJwt(
        val secret: String
): AuthInterface{
    private val algorithm = Algorithm.HMAC256(secret)
    val verifier = JWT.require(algorithm).build()

    override fun sign(pass: String): String = JWT.create().withClaim("pass",pass).sign(algorithm)
    override fun rSecret(): String {
        return secret
    }
}