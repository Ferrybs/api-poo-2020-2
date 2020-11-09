package com.sfinancial.config.nettyConfig

import java.io.File
import java.lang.Exception

class NettyConfigRead : NettyConfigInterface {
    override fun getHost(): String {
        try {
            return File("connectionHost.txt").readLines()[0]
        }catch (e : Exception){
            throw e
        }
    }
    override fun getPort(): Int {
        try {
            return File("connectionPort.txt").readLines()[0].toInt()
        }catch (e : Exception){
            throw e
        }
    }
}