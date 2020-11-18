package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeClassifierAuth.classifierLogin
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
    }
}