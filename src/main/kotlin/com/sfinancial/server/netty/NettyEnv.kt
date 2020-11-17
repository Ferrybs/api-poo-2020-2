package com.sfinancial.server.netty

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.config.nettyConfig.NettyConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.feature.authJwt.moduleJwt
import com.sfinancial.feature.doubleReceive.moduleDoubleReceive
import com.sfinancial.feature.gson.moduleGson
import com.sfinancial.feature.statusPages.moduleStatusPages
import com.sfinancial.route.routes
import io.ktor.server.engine.*

abstract class NettyEnv(
        private val authInterface: AuthInterface,
        private val nettyConfigInterface: NettyConfigInterface,
        private val dbInterface: DBInterface,
        private val idAdminInterface: IdAdminInterface
){
    fun getEnv(): ApplicationEngineEnvironment {
        try {
            return applicationEngineEnvironment {
                connector {
                    host = nettyConfigInterface.getHost()
                    port = nettyConfigInterface.getPort()
                }
                module {
                    moduleDoubleReceive()
                    moduleStatusPages()
                    moduleJwt(authInterface)
                    moduleGson()
                    routes(authInterface,dbInterface,idAdminInterface)
                }
            }
        }catch (e: Exception){
            throw e
        }
    }
}
