package com.sfinancial.config.hashidConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class EnvHashIdConfig: HashIdConfigInterface {
    override fun getSecretHashid():String{
        return try {
            File("secretHashid.txt").readLines()[0]
        }catch (e: FileNotFoundException) {
            try {
                System.getenv("sHashid")
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }
}