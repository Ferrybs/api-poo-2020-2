package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.server.ServerInterface
import io.ktor.server.engine.*
import io.ktor.server.netty.*


class NettyServer(
        authInterface: AuthInterface,
        dbInterface: DBInterface
) : ServerInterface, NettyEnv(authInterface,dbInterface) {

    private val server = embeddedServer(Netty, env)

    override fun start() {
        this.server.start(wait = true)
    }

    override fun rDatabase(): DBInterface {
        return getDbInterface()
    }


}