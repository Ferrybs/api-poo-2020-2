package com.sfinancial.server.netty

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.config.hashidConfig.HashIdConfigInterface
import com.sfinancial.config.nettyConfig.NettyConfigInterface
import com.sfinancial.database.DBInterface

class NettyFactory(
        private val nettyConfigInterface: NettyConfigInterface,
        private val authInterface: AuthInterface,
        private val dbInterface: DBInterface,
        private val idAdminInterface: IdAdminInterface
) {

    fun connect(): NettyServer{
       try {
           return NettyServer(authInterface,dbInterface,nettyConfigInterface,idAdminInterface)
       }catch (e: Exception){
           throw e
       }
    }
}