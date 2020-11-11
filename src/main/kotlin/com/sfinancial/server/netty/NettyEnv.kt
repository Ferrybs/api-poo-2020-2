package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.config.nettyConfig.NettyConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.feature.authJwt.moduleJwt
import com.sfinancial.feature.cors.moduleCors
import com.sfinancial.feature.gson.moduleGson
import com.sfinancial.feature.statusPages.moduleStatusPages
import com.sfinancial.route.routes
import io.ktor.server.engine.*

abstract class NettyEnv(
        private val authInterface: AuthInterface,
        private val dbInterface: DBInterface,
        private val nettyConfigInterface: NettyConfigInterface
){
    fun getEnv(): ApplicationEngineEnvironment {
        try {
            return applicationEngineEnvironment {
                module {
                    moduleCors()
                    moduleStatusPages()
                    moduleJwt(getAuthInterface())
                    moduleGson()
                    routes(getDbInterface(),getAuthInterface())
                }
                connector {
                    host = getHost()
                    port = getPort()
                }
            }
        }catch (e: Exception){
            throw e
        }
    }
    private fun getHost():String{
        try {
            return  nettyConfigInterface.getHost()
        }catch (e: Exception){
            throw e
        }
    }
    private fun getPort(): Int{
        try {
            return nettyConfigInterface.getPort()
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
