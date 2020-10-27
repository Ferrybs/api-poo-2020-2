package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.feature.authJwt.moduleJwt
import com.sfinancial.feature.gson.moduleGson
import com.sfinancial.feature.statusPages.moduleStatusPages
import com.sfinancial.route.routes
import io.ktor.server.engine.*

abstract class NettyEnv(
        private val authInterface: AuthInterface,
        private val dbInterface: DBInterface
){
    fun getEnv(): ApplicationEngineEnvironment {
        try {
            return applicationEngineEnvironment {
                module {
                    //querendo mudar para moduleList mas n consegui implementar - Felipe Araujo
                    moduleStatusPages()
                    moduleJwt(getAuthInterface())
                    moduleGson()
                    routes(getDbInterface(),getAuthInterface())
                }
                connector {
                    host = "0.0.0.0"
                    port = 8080
                }
            }
        }catch (e: Exception){
            throw e
        }
    }
    private fun getAuthInterface(): AuthInterface{
        try {
            return authInterface
        }catch (e: Exception){
            throw e
        }
    }
    fun getDbInterface(): DBInterface {
        try {
            return dbInterface
        }catch (e: Exception){
            throw e
        }
    }
}
