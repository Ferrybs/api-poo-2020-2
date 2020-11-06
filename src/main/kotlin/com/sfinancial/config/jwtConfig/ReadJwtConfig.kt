package com.sfinancial.config.jwtConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadJwtConfig: JwtConfigInterface {
    override fun getSecretJwt():String{
        return try {
            File("secretJwt.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            try {
                System.getenv("secretJwt")
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }

    override fun getIssuer(): String{
        return try {
            File("connectionIssuer.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            try {
                System.getenv("connectionIssuer")
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }
}