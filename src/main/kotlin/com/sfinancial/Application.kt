package com.sfinancial

import com.sfinancial.config.Config
import com.sfinancial.config.databaseConfig.MongoConfig
import com.sfinancial.config.hashidConfig.ReadHashIdConfig
import com.sfinancial.config.jwtConfig.ReadJwtConfig
import com.sfinancial.config.nettyConfig.ReadNettyConfig
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){
    var config: Config
    try {
        val readHashIdConfig = ReadHashIdConfig()
        val readJwtConfig = ReadJwtConfig()
        val readNettyConfig = ReadNettyConfig()
        val mongoConfig = MongoConfig()
        config = Config(
                readHashIdConfig,
                readJwtConfig,
                readNettyConfig,
                mongoConfig)
    }catch (e: Exception){
        throw e
    }
    var server: NettyServer
    try {
        server = NettyFactory(config).connect()
    }catch (e: Exception){
        throw e
    }

    val sfinancial = Sfinancial(server)
    sfinancial.startServer()
}