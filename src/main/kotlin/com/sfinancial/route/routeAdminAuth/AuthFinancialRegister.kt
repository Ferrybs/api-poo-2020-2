package com.sfinancial.route.routeAdminAuth

import com.sfinancial.group.Financial
import com.sfinancial.permission.FinancialPermission


import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*


internal fun Route.financialRegister(dbInterface: DBInterface,idAdminInterface: IdAdminInterface) {
    authenticate {
        post("/admin/register-financial") {
            try {
                val financialLogin = call.principal<Login>() ?: error("No principal")
                val financial = call.receive<Financial>()
                FinancialPermission(dbInterface).createAccount(financialLogin,financial, idAdminInterface)
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
}
