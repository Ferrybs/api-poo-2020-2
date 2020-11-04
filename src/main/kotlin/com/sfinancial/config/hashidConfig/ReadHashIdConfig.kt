package com.sfinancial.config.hashidConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadHashIdConfig: HashIdConfigInterface {
    override fun getSecretHashid():String{
        try {
            return File("secretJwt.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: secretJwt nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
}