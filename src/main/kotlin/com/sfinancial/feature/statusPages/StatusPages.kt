package com.sfinancial.feature.statusPages

import com.sfinancial.notification.exception.FailedVerifier
import com.sfinancial.notification.exception.InvalidCredential
import com.sfinancial.notification.exception.InvalidFields
import com.sfinancial.notification.exception.InvalidRequest
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.moduleStatusPages(){
    install(StatusPages){
        exception<InvalidCredential>{ exception ->
            call.respond(HttpStatusCode.Unauthorized, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<InvalidFields>{ exception ->
            call.respond(HttpStatusCode.NotAcceptable, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<InvalidRequest>{ exception ->
            call.respond(HttpStatusCode.BadRequest, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<FailedVerifier>{ exception ->
            call.respond(HttpStatusCode.NotAcceptable, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
    }
}