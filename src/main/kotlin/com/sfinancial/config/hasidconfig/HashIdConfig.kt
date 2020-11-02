package com.sfinancial.config.hasidconfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class HashIdConfig: HashIdInterface {
    override fun getString(): String {
        try {
            return File("SecretHashId.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo nao SecretHashId encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
}