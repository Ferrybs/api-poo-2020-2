package com.sfinancial.config.jwtConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class EnvJwtConfig: JwtConfigInterface {
    override fun getSecretJwt():String{
        return try {
            File("secretJwt.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            try {
                System.getenv("sJwt")
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
                System.getenv("cIssuer")
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }
}