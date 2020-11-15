package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.config.nettyConfig.NettyConfigInterface
import com.sfinancial.database.DBInterface

class NettyFactory(
        private val authInterface: AuthInterface,
        private val nettyConfigInterface: NettyConfigInterface,
        private val dbInterface: DBInterface
) {

    fun connect(): NettyServer{
       try {
           return NettyServer(authInterface,dbInterface,nettyConfigInterface)
       }catch (e: Exception){
           throw e
       }
    }
}