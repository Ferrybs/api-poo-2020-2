package com.sfinancial.server.netty

import com.sfinancial.auth.AuthInterface
import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.ConfigInterface
import com.sfinancial.config.nettyConfig.NettyConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.MongoManagement

class NettyFactory(
        private val dbInterface: DBInterface,
        private val authInterface: AuthInterface,
        private val nettyConfigInterface: NettyConfigInterface
) {



    fun connect(): NettyServer{
       try {
           return NettyServer(authInterface,dbInterface,nettyConfigInterface)
       }catch (e: Exception){
           throw e
       }
    }
}