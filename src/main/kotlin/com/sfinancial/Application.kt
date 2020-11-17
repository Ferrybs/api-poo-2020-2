package com.sfinancial

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.mongoConfig.MongoConfigInterface
import com.sfinancial.config.jwtConfig.JwtConfigInterface
import com.sfinancial.config.jwtConfig.ReadJwtConfig
import com.sfinancial.config.mongoConfig.IndexMongoConfig
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.config.nettyConfig.ReadNettyConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){
    try {
        setMongodb()
    }catch (e: Exception){
        println("Error to setMongodb: ${e.message}")
    }
    val envMongoConfig = ReadMongoConfig()
    val envJwtConfig = ReadJwtConfig()

    var server: NettyServer
    try {
        server = NettyFactory(
            getAuthJwt(envJwtConfig),
            ReadNettyConfig(),
            getMongoDB(envMongoConfig)
        ).connect()
    }catch (e: Exception){
        throw e
    }
    val sfinancial = Sfinancial(server)
    sfinancial.startServer()

}

private fun getMongoDB(MongoConfigInterface: MongoConfigInterface): StrategyMongodb{
    try {
        val cString = MongoConfigInterface.getConnectionString()
        val dbName = MongoConfigInterface.getDatabaseName()
        return StrategyMongodb(cString,dbName)
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
private fun setMongodb(){
    val idx = IndexMongoConfig()
    idx.setUserAccount()
    idx.setCreditCard()
}