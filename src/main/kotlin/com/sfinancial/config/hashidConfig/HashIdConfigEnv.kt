package com.sfinancial.config.hashidConfig

class HashIdConfigEnv: HashIdConfigInterface {
    override fun getSecretHashid():String{
        return try {
                System.getenv("sHashid")
            }catch (e: Exception){
                throw e
            }
    }
}