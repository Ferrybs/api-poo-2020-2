package com.sfinancial.config.hashidConfig

import java.io.File

class HashidConfigRead: HashIdConfigInterface {
    override fun getSecretHashid(): String {
        try {
            return File("secretHashid.txt").readLines()[0]
        }catch (e : Exception){
            throw e
        }
    }
}