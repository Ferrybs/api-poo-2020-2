package com.sfinancial

import com.sfinancial.server.netty.NettyConfig
import com.sfinancial.server.netty.NettyFactory
import com.sfinancial.server.netty.NettyServer


fun main(){
    val nettyConfig = NettyConfig()
    var server: NettyServer
    try {
        server = NettyFactory(nettyConfig).connect()
    }catch (e: Exception){
        throw e
    }
    val sfinancial = Sfinancial(server)
    sfinancial.startServer()
}