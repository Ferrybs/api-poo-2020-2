package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.config.nettyconfig.ConfigNettyInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.feature.authJwt.moduleJwt
import com.sfinancial.feature.gson.moduleGson
import com.sfinancial.feature.statusPages.moduleStatusPages
import com.sfinancial.route.routes
import io.ktor.server.engine.*

abstract class NettyEnv(
        private val authInterface: AuthInterface,
        private val dbInterface: DBInterface,
        private val configNettyInterface: ConfigNettyInterface
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
                    host = getHost()
                    port = getPort()
                }
            }
        }catch (e: Exception){
            throw e
        }
    }
    private fun getHost():String{
        var host: String = "0.0.0.0"
        try {
            host = configNettyInterface.getHost()
        }catch (e: Exception){
            println("error detecting host opening at: $host")
        }finally {
            return host
        }
    }
    private fun getPort(): Int{
        var port: Int = 8080
        try {
            port = configNettyInterface.getPort()
        }catch (e: Exception){
            println("error detecting port opening at: $port")
        }finally {
            return port
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
