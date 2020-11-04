package com.sfinancial.config.jwtConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadJwtConfig: JwtConfigInterface {
    override fun getSecretJwt():String{
        try {
            return File("secretHashid.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: secretHashid nao encontrado!")
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
}