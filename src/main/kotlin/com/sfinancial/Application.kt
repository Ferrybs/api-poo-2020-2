package com.sfinancial

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.mongoConfig.mongoConfigInterface
import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.config.jwtConfig.EnvJwtConfig
import com.sfinancial.config.jwtConfig.JwtConfigInterface
import com.sfinancial.config.nettyConfig.EnvNettyConfig
import com.sfinancial.database.mongodb.MongoManagement
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){

    val envMongoConfig = EnvMongoConfig()
    val envJwtConfig = EnvJwtConfig()

    var server: NettyServer
    try {
        server = NettyFactory(
                getMongoDB(envMongoConfig),
                getAuthJwt(envJwtConfig),
                EnvNettyConfig()
        ).connect()
    }catch (e: Exception){
        throw e
    }

    val sfinancial = Sfinancial(server)
    sfinancial.startServer()
}

private fun getMongoDB(mongoConfigInterface: mongoConfigInterface): MongoManagement{
    try {
        val cString = mongoConfigInterface.getConnectionString()
        val dbName = mongoConfigInterface.getDatabaseName()
        return MongoManagement(cString,dbName)
    }catch (e: Exception){
        throw e
    }
}
private fun getAuthJwt(jwtConfigInterface: JwtConfigInterface): AuthJwt {
    try {
        val secret = jwtConfigInterface.getSecretJwt()
        val issuer = jwtConfigInterface.getIssuer()
        return AuthJwt(secret,issuer)
    }catch (e: Exception){
        throw e
    }
}