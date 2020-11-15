package com.sfinancial.route.routeUserAuth


import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.group.User
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.exception.InvalidRequestException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.routing.*


internal fun Route.register() {
    post("/register") {
        val user = call.receiveOrNull<User>()
        if(user != null){
            try {
                val env = EnvMongoConfig()
                val mongo = StrategyMongodb(env.getConnectionString(),env.getDatabaseName())
                UserPermission(mongo).createAccount(user)
                throw StatusPageCreated("User account successfully created!")
            }catch (e: FailedVerifierException) {
                throw e
            }catch (e: Exception){
                throw InvalidFieldsException("Invalid fields! Message: ${e.message}")
            }
        }
        throw InvalidRequestException("User cannot be null!")
    }
}
