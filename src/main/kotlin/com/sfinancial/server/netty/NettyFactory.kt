package com.sfinancial.server.netty

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.readNettyConfig.ReadNettyConfigInterface
import com.sfinancial.database.mongodb.MongoManagement

class NettyFactory(
        private val readNettyConfigInterface: ReadNettyConfigInterface
) {



    fun connect(): NettyServer{
       try {
           return NettyServer(getJwt(),getMongoDB(),readNettyConfigInterface)
       }catch (e: Exception){
           throw e
       }
    }


    private fun getMongoDB(): MongoManagement {
        try {
            val connectionString =  readNettyConfigInterface.getConnectionString()
            val databaseName = readNettyConfigInterface.getDatabaseName()
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
            val secret = readNettyConfigInterface.getSecretJwt()
            val issuer = readNettyConfigInterface.getIssuer()
            return AuthJwt(secret,issuer)
        }catch (e: Exception){
            throw e
        }
    }
}