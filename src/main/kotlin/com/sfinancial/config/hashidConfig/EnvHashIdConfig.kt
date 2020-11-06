package com.sfinancial.config.hashidConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class EnvHashIdConfig: HashIdConfigInterface {
    override fun getSecretHashid():String{
        return try {
                System.getenv("sHashid")
            }catch (e: Exception){
                throw e
            }
    }
}