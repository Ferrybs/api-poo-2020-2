package com.sfinancial

import com.sfinancial.admin.idAdmin.HashIdAdmin
import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.hashidConfig.HashIdConfigInterface
import com.sfinancial.config.hashidConfig.ReadHashidConfig
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
    val mongoConfig = ReadMongoConfig()
    val jwtConfig = ReadJwtConfig()
    val hashIdConfig = ReadHashidConfig()

    val server: NettyServer
    try {
        server = NettyFactory(
                ReadNettyConfig(),
                getAuthJwt(jwtConfig),
                getMongoDB(mongoConfig),
                getHashId(hashIdConfig)
        ).connect()
    }catch (e: Exception){
        throw e
    }
    val sFinancial = Sfinancial(server)
    sFinancial.startServer()

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

private fun getHashId(hashIdIdConfigInterface: HashIdConfigInterface): HashIdAdmin {
    return HashIdAdmin(hashIdIdConfigInterface)
}

private fun setMongodb(){
    val idx = IndexMongoConfig()
    idx.setUserAccount()
    idx.setCreditCard()
    idx.setClassifier()
}