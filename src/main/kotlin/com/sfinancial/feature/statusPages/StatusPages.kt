package com.sfinancial.feature.statusPages

import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.exception.InvalidRequestException
import com.sfinancial.notification.statusPages.StatusPageCreated
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.moduleStatusPages(){
    install(StatusPages){
        exception<InvalidCredentialException>{ exception ->
            call.respond(HttpStatusCode.Unauthorized, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<InvalidFieldsException>{ exception ->
            call.respond(HttpStatusCode.NotAcceptable, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<InvalidRequestException>{ exception ->
            call.respond(HttpStatusCode.BadRequest, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<FailedVerifierException>{ exception ->
            call.respond(HttpStatusCode.NotAcceptable, mapOf("OK" to false, "error" to (exception.message ?: "")))
        }
        exception<StatusPageCreated>{ exception ->
            call.respond(HttpStatusCode.Created, mapOf("OK" to true, "message" to (exception.message ?: "")))
        }
    }
}