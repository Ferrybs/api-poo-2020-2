package com.sfinancial

import com.sfinancial.config.readNettyConfig.ReadReadNettyConfig
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){
    val nettyConfig = ReadReadNettyConfig()
    var server: NettyServer
    try {
        server = NettyFactory(nettyConfig).connect()
    }catch (e: Exception){
        throw e
    }

    val sfinancial = Sfinancial(server)
    sfinancial.startServer()
}