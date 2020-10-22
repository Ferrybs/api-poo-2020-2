package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.feature.authJwt.moduleJwt
import com.sfinancial.feature.gson.moduleGson
import com.sfinancial.feature.statusPages.moduleStatusPages
import com.sfinancial.route.routes
import io.ktor.server.engine.*

abstract class NettyEnv(
        private var authInterface: AuthInterface,
        private val dbInterface: DBInterface
){
    val env = applicationEngineEnvironment {
        module {
            moduleStatusPages()
            moduleJwt(authInterface)
            moduleGson()
            routes(dbInterface,authInterface)
        }
        connector {
            host = "0.0.0.0"
            port = 8080
        }
    }
    fun getDbInterface(): DBInterface {
        return dbInterface
    }
}
