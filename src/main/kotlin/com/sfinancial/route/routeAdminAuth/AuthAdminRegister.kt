package com.sfinancial.route.routeAdminAuth


import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.group.Admin
import com.sfinancial.group.Classifier
import com.sfinancial.group.User
import com.sfinancial.login.AdminLogin
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.exception.InvalidRequestException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.AdminPermission
import com.sfinancial.permission.ClassifierPermission
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*


internal fun Route.adminRegister(dbInterface: DBInterface,idAdminInterface: IdAdminInterface) {
   authenticate {
       post("/admin/register") {
           try {
               val adminLogin = call.principal<UserLogin>() ?: error("No principal")
               val admin = call.receive<Admin>()
               AdminPermission(dbInterface).createAccount(adminLogin,admin,dbInterface,idAdminInterface)
               throw StatusPageCreated("Admin account successfully created!")
           } catch (e: StatusPageCreated) {
               throw e
           } catch (e: FailedVerifierException) {
               throw e
           } catch (e: InvalidFieldsException) {
               throw e
           } catch (e: Exception) {
               throw InvalidFieldsException("${e.message}")
           }
       }
   }
}
