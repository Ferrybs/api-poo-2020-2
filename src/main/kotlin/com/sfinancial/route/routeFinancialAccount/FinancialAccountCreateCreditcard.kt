package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCreditCard
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.FinancialPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

fun Route.financialCreateCreditCard(dbInterface: DBInterface) {
    authenticate {
        post("/financial/create-credit-card") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val post = call.receive<CallUserAccountCreditCard>()
                FinancialPermission(dbInterface).createCreditCard(principal,post)
                throw StatusPageCreated("Credit card has been created successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}