package com.sfinancial.route.routeUserAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeUserAuth.login
import com.sfinancial.route.routeUserAuth.register
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.userAccountRoutes(
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    routing {
        myUserAccount(dbInterface)

        addCategory(dbInterface,idAdminInterface)
        addCreditCard(dbInterface)
        addTransaction(dbInterface,idAdminInterface)

        updateAddress(dbInterface)
        updateCategory(dbInterface)
        updateTransaction(dbInterface)

        deleteAddress(dbInterface)


    }
}