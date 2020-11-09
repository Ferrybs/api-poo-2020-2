package com.sfinancial.feature.statusPages

import com.sfinancial.notification.exception.ExceptionFailedVerifier
import com.sfinancial.notification.exception.ExceptionInvalidCredential
import com.sfinancial.notification.exception.ExceptionInvalidFields
import com.sfinancial.notification.exception.ExceptionInvalidRequest
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.moduleStatusPages(){
    install(StatusPages){
        exception<ExceptionInvalidCredential>{ exception ->
            call.respond(HttpStatusCode.Unauthorized, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<ExceptionInvalidFields>{ exception ->
            call.respond(HttpStatusCode.NotAcceptable, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<ExceptionInvalidRequest>{ exception ->
            call.respond(HttpStatusCode.BadRequest, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<ExceptionFailedVerifier>{ exception ->
            call.respond(HttpStatusCode.NotAcceptable, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
    }
}