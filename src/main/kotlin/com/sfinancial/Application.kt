package com.sfinancial

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.mongoConfig.MongoConfigInterface
import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.config.jwtConfig.EnvJwtConfig
import com.sfinancial.config.jwtConfig.JwtConfigInterface
import com.sfinancial.config.jwtConfig.ReadJwtConfig
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.config.nettyConfig.EnvNettyConfig
import com.sfinancial.config.nettyConfig.ReadNettyConfig
import com.sfinancial.database.mongodb.MongoManagement
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){

    val envMongoConfig = ReadMongoConfig()
    val envJwtConfig = ReadJwtConfig()

    var server: NettyServer
    try {
        server = NettyFactory(
                getMongoDB(envMongoConfig),
                getAuthJwt(envJwtConfig),
                ReadNettyConfig()
        ).connect()
    }catch (e: Exception){
        throw e
    }

    val sfinancial = Sfinancial(server)
    sfinancial.startServer()
}

private fun getMongoDB(MongoConfigInterface: MongoConfigInterface): MongoManagement{
    try {
        val cString = MongoConfigInterface.getConnectionString()
        val dbName = MongoConfigInterface.getDatabaseName()
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