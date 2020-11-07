package com.sfinancial.config.jwtConfig

import java.io.File

class ReadJwtConfig : JwtConfigInterface {
    override fun getSecretJwt(): String {
        try{
            return File("secretJwt.txt").readLines()[0]
        }catch (e : Exception){
            throw e
        }
    }
    override fun getIssuer(): String {
        try{
            return File("connectionIssuer.txt").readLines()[0]
        }catch(e : Exception){
            throw e
        }
    }
}
