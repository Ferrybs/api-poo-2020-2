package com.sfinancial.config.nettyconfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class NettyConfig: ConfigNettyInterface {

    override fun getConnectionString(): String {
        try {
            return File("ConnectionString.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getDatabaseName(): String{
        try {
            return File("databaseName.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao databaseName encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getSecretJwt():String{
        try {
            return File("secretJwt.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao secretJwt encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getIssuer(): String{
        try {
            return File("Issuer.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao Issuer encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getHost(): String {
        try {
            return File("Host.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo host nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getPort():Int{
        try {
            return File("Port.txt").readLines()[0].toInt()
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo port nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
}