package com.sfinancial.route.routeAdminAuth


import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.group.Admin
import com.sfinancial.group.Classifier
import com.sfinancial.group.User
import com.sfinancial.login.AdminLogin
import com.sfinancial.login.ClassifierLogin
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.exception.InvalidRequestException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.AdminPermission
import com.sfinancial.permission.ClassifierPermission
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.adminLogin(dbInterface: DBInterface,idAdminInterface: IdAdminInterface) {
   authenticate {
       get("/admin/login") {
       }
   }
}
