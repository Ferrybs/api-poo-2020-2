package com.sfinancial.config.nettyconfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class NettyConfig: ConfigNettyInterface {

    override fun getConnectionString(): String {
        try {
            return File("connectionString.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: connectionString nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getDatabaseName(): String{
        try {
            return File("databaseName.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: databaseName nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getSecretJwt():String{
        try {
            return File("secretHashid.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: secretHashid nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getSecretHashid():String{
        try {
            return File("secretJwt.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: secretJwt nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getIssuer(): String{
        try {
            return File("connectionIssuer.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: connectionIssuer nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
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