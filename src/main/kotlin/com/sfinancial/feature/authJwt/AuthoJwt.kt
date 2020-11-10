package com.sfinancial.feature.authJwt

import com.sfinancial.auth.AuthInterface
import com.sfinancial.auth.AuthJwt
import com.sfinancial.login.UserLogin
import io.ktor.auth.*
import io.ktor.application.*
import io.ktor.auth.jwt.*

fun Application.moduleJwt(authInterface: AuthInterface) {
    val authTwt = AuthJwt(authInterface.rSecret(),authInterface.rIssuer())
    install(Authentication) {
        jwt {
            verifier(authTwt.verifier)
            validate {
                val username = it.payload.getClaim("username").asString()
                val password = it.payload.getClaim("password").asString()
                if (username!= null && password !=null){
                    UserLogin(username,password)
                }
                null
            }
        }
    }
}
