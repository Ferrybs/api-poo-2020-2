package com.sfinancial.route.routeAuth


import com.sfinancial.database.DBInterface
import io.ktor.routing.*


internal fun Route.register(dbInterface: DBInterface) {
    post("/register") {

    }
}
