package com.sfinancial.config.hashidConfig

class EnvHashIdConfig: HashIdConfigInterface {
    override fun getSecretHashId():String{
        return try {
                System.getenv("sHashid")
            }catch (e: Exception){
                throw e
            }
    }
}