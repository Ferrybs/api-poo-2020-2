package com.sfinancial.config.jwtConfig

class JwtConfigEnv: JwtConfigInterface {
    override fun getSecretJwt():String{
        return try {
                System.getenv("sJwt")
            }catch (e: Exception){
                throw e
            }
    }

    override fun getIssuer(): String{
        return try {
                System.getenv("cIssuer")
            }catch (e: Exception){
                throw e
            }
    }
}