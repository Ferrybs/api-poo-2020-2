package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.financialRoutes(
        authInterface: AuthInterface,
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    routing {
        financialCreateCreditCard(dbInterface)
        financialCreateTransaction(dbInterface,idAdminInterface)

        financialGetCreditCard(dbInterface)
        financialGetTransaction(dbInterface)
        financialUpdateTransaction(dbInterface)

        financialDeleteTransaction(dbInterface)
        financialDeleteCreditCard(dbInterface)
    }
}