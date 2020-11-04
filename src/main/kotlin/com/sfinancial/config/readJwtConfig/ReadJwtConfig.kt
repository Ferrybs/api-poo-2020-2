package com.sfinancial.config.readJwtConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadJwtConfig: ReadJwtConfigInterface {
    override fun getSecretJwt():String{
        try {
            return File("secretHashid.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: secretHashid nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
}