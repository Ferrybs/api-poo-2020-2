package com.sfinancial.server.netty

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.nettyconfig.NettyConfig
import com.sfinancial.database.mongodb.MongoManagement

class NettyFactory(
        private val nettyConfig: NettyConfig
) {
    fun connect(): NettyServer{
       try {
           return NettyServer(getJwt(),getMongoDB())
       }catch (e: Exception){
           throw e
       }
    }
    private fun getMongoDB(): MongoManagement {
        try {
            val connectionString =  nettyConfig.getConnectionString()
            val databaseName = nettyConfig.getDatabaseName()
            return MongoManagement(
                    connectionString,
                    databaseName
            )
        }catch (e: Exception){
            throw e
        }
    }
    private fun getJwt(): AuthJwt {
        try {
            val secret = nettyConfig.getSecretJwt()
            val issuer = nettyConfig.getIssuer()
            return AuthJwt(secret,issuer)
        }catch (e: Exception){
            throw e
        }
    }
}