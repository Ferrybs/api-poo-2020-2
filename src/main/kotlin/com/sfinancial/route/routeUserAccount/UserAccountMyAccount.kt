package com.sfinancial.route.routeUserAccount

import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.ManagementMongodb
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.myUserAccount(){
    authenticate {
        get("/myUserAccount") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            val env = EnvMongoConfig()
            val mongo = ManagementMongodb(env.getConnectionString(),env.getDatabaseName())
            try {
                val user = UserPermission(mongo).getUserAccount(userLogin)
                call.respond(HttpStatusCode.Found,user)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}