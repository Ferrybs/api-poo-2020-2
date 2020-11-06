package com.sfinancial

import com.sfinancial.config.Config
import com.sfinancial.config.databaseConfig.EnvMongoConfig
import com.sfinancial.config.hashidConfig.EnvHashIdConfig
import com.sfinancial.config.jwtConfig.EnvJwtConfig
import com.sfinancial.config.nettyConfig.EnvNettyConfig
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){
    var config: Config
    try {
        val readHashIdConfig = EnvHashIdConfig()
        val readJwtConfig = EnvJwtConfig()
        val readNettyConfig = EnvNettyConfig()
        val mongoConfig = EnvMongoConfig()
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