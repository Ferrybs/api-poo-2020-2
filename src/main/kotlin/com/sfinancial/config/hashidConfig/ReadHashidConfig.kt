package com.sfinancial.config.hashidConfig

import java.io.File

class ReadHashidConfig: HashIdConfigInterface {
    override fun getSecretHashId(): String {
        try {
            return File("secretHashid.txt").readLines()[0]
        }catch (e : Exception){
            throw e
        }
    }
}