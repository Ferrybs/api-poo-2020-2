package com.sfinancial.config.nettyConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadNettyConfig: NettyConfigInterface {


    override fun getHost(): String {
        return try {
                System.getenv("connectionHost") ?: "0.0.0.0"
            }catch (e: Exception){
                throw e
            }
    }
    override fun getPort():Int{
        return try {
                System.getenv("connectionPort").toInt()
            }catch (e: Exception){
                throw e
            }
    }
}