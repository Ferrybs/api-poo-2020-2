package com.sfinancial.config.nettyConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadNettyConfig: NettyConfigInterface {


    override fun getHost(): String {
        return try {
            return File("connectionHost.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            try {
                System.getenv("connectionHost")
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun getPort():Int{
        return try {
            File("connectionPort.txt").readLines()[0].toInt()
        }catch (e: FileNotFoundException){
            try {
                System.getenv("connectionPort").toInt()
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }
}