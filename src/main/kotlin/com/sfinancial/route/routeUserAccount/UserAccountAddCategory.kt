package com.sfinancial.route.routeUserAccount

import com.sfinancial.category.Category
import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.ManagementMongodb
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*
import java.util.*

fun Route.addCategory(dbInterface: DBInterface){
    authenticate {
        post("/myUserAccount/addCategory") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val post = call.receiveOrNull<Category>()
                if (post !=null){
                    UserPermission(dbInterface).createCategory(userLogin,post)
                    throw StatusPageCreated("Category has been created successfully")
                }
            }catch (e: StatusPageCreated){
                throw e
            }catch (e: Exception){
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}