package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.call.CallUserAccountCreditCard
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.permission.FinancialPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

fun Route.financialDeleteCreditCard(dbInterface: DBInterface, idAdminInterface: IdAdminInterface) {
    authenticate {
        delete("/financial/delete-credit-card") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val delete = call.receive<CreditCard>()
                FinancialPermission(dbInterface).deleteCreditCard(principal,delete)
                throw StatusPageCreated("Credit card has been deleted successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}