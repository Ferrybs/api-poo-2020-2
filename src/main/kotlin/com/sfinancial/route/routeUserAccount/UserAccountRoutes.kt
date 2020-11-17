package com.sfinancial.route.routeUserAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface
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
        deleteCategory(dbInterface)
        deleteTransaction(dbInterface)
        deleteCreditCard(dbInterface)

    }
}