package com.sfinancial.route.routeHome

import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.homeRoutes(){
    routing {
        home()
    }
}