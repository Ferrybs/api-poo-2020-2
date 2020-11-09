package com.sfinancial

import com.sfinancial.auth.AuthJwt
import com.sfinancial.config.mongoConfig.MongoConfigInterface
import com.sfinancial.config.jwtConfig.JwtConfigInterface
import com.sfinancial.config.jwtConfig.JwtConfigRead
import com.sfinancial.config.mongoConfig.MongoConfigIndex
import com.sfinancial.config.mongoConfig.MongoConfigRead
import com.sfinancial.config.nettyConfig.NettyConfigRead
import com.sfinancial.database.mongodb.MongoDbManagement
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){

    val envMongoConfig = MongoConfigRead()
    val envJwtConfig = JwtConfigRead()

    var server: NettyServer
    try {
        server = NettyFactory(
                getMongoDB(envMongoConfig),
                getAuthJwt(envJwtConfig),
                NettyConfigRead()
        ).connect()
    }catch (e: Exception){
        throw e
    }
    //set Indexs Mongodb
    try {
        setMongodb()
    }catch (e: Exception){
        println("Error to setMongodb: ${e.message}")
    }

    val sfinancial = Sfinancial(server)
    sfinancial.startServer()
}

private fun getMongoDB(MongoConfigInterface: MongoConfigInterface): MongoDbManagement{
    try {
        val cString = MongoConfigInterface.getConnectionString()
        val dbName = MongoConfigInterface.getDatabaseName()
        return MongoDbManagement(cString,dbName)
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
    MongoConfigIndex().setUserAccount()
}