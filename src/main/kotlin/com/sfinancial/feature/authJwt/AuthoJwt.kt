package com.sfinancial.feature.authJwt

import com.sfinancial.auth.AuthInterface
import com.sfinancial.auth.AuthJwt
import io.ktor.auth.*
import io.ktor.application.*
import io.ktor.auth.jwt.*

fun Application.moduleJwt(authInterface: AuthInterface) {
    val authTwt = AuthJwt(authInterface.rSecret())
    install(Authentication) {
        jwt {
            verifier(authTwt.verifier)
            validate {
                UserIdPrincipal(it.payload.getClaim("pass").asString())
            }
        }
    }
}
