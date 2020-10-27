package com.sfinancial.server.netty

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class NettyConfig {
    fun getConnectionString(): String {
        try {
            return File("ConnectionString.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    fun getDatabaseName(): String{
        try {
            return File("databseName.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    fun getSecret():String{
        try {
            return File("secret.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    fun getIssuer(): String{
        try {
            return File("Issuer.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
}