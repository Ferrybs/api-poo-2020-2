package com.sfinancial.server.netty

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.mongodb.MongoManagement

class NettyFactory(
        private val configInterface: ConfigInterface
) {



    fun connect(): NettyServer{
       try {
           return NettyServer(getJwt(),getMongoDB(),configInterface)
       }catch (e: Exception){
           throw e
       }
    }


    private fun getMongoDB(): MongoManagement {
        try {
            val connectionString =  configInterface.getConnectionString()
            val databaseName = configInterface.getDatabaseName()
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
            val secret = configInterface.getSecretJwt()
            val issuer = configInterface.getIssuer()
            return AuthJwt(secret,issuer)
        }catch (e: Exception){
            throw e
        }
    }
}