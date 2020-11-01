package com.sfinancial.server.netty

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.nettyconfig.ConfigNettyInterface
import com.sfinancial.config.nettyconfig.NettyConfig
import com.sfinancial.database.mongodb.MongoManagement

class NettyFactory(
        private val configNettyInterface: ConfigNettyInterface
) {



    fun connect(): NettyServer{
       try {
           return NettyServer(getJwt(),getMongoDB(),configNettyInterface)
       }catch (e: Exception){
           throw e
       }
    }


    private fun getMongoDB(): MongoManagement {
        try {
            val connectionString =  configNettyInterface.getConnectionString()
            val databaseName = configNettyInterface.getDatabaseName()
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
            val secret = configNettyInterface.getSecretJwt()
            val issuer = configNettyInterface.getIssuer()
            return AuthJwt(secret,issuer)
        }catch (e: Exception){
            throw e
        }
    }
}