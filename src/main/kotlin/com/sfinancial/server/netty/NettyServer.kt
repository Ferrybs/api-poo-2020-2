package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.server.ServerInterface
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlin.Exception


class NettyServer(
        authInterface: AuthInterface,
        dbInterface: DBInterface
) : ServerInterface, NettyEnv(authInterface,dbInterface) {

    private fun getServer(): NettyApplicationEngine {
        try {
            return embeddedServer(Netty, getEnv())
        }catch (e: Exception){
            throw e
        }
    }

    override fun start() {
        try {
            this.getServer().start(wait = true)
        }catch (e: Exception){
            throw e
        }
    }

    override fun rDatabase(): DBInterface {
        try {
            return getDbInterface()
        }catch (e: Exception){
            throw e
        }
    }

}