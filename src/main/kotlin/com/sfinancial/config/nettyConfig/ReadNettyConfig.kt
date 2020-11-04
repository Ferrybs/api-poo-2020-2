package com.sfinancial.config.nettyConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadNettyConfig: NettyConfigInterface {


    override fun getHost(): String {
        try {
            return File("connectionHost.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: connectionHost nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getPort():Int{
        try {
            return File("connectionPort.txt").readLines()[0].toInt()
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: connectionPort nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
}