package com.sfinancial.route.routeAdminAuth

import com.sfinancial.group.Financial
import com.sfinancial.permission.FinancialPermission


import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.group.Classifier
import com.sfinancial.group.User
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.exception.InvalidRequestException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.ClassifierPermission
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.routing.*


internal fun Route.financialRegister(dbInterface: DBInterface,idAdminInterface: IdAdminInterface) {
    post("/admin/register-financial") {
        try {
            val financial = call.receive<Financial>()
            FinancialPermission(dbInterface).createAccount(financial, idAdminInterface)
            throw StatusPageCreated("Financial account successfully created!")
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
