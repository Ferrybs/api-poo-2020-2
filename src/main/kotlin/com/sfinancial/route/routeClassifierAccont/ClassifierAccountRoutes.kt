package com.sfinancial.route.routeClassifierAccont

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.classifierAccountRotes(
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    routing {
        classifierAddCategory(dbInterface,idAdminInterface)
        classifierGetCategory(dbInterface)
        classifierUpdateCategory(dbInterface)
        classifierDeleteCategory(dbInterface)
    }
}