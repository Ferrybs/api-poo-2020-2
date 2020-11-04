package com.sfinancial.config.readHashidConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadReadHashIdConfig: ReadHashIdInterface {
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