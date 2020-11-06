package com.sfinancial.config.nettyConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class EnvNettyConfig: NettyConfigInterface {


    override fun getHost(): String {
        return try {
                System.getenv("cHost") ?: "0.0.0.0"
            }catch (e: Exception){
                throw e
            }
    }
    override fun getPort():Int{
        return try {
                System.getenv("PORT").toInt()
            }catch (e: Exception){
                throw e
            }
    }
}