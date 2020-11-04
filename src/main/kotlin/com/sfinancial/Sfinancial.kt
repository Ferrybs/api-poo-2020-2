package com.sfinancial

import com.sfinancial.server.ServerInterface
import java.lang.Exception

internal data class Sfinancial(
        private val server: ServerInterface
){
    fun startServer() {
        try {
            server.start()
        }catch (e: Exception){
            throw e
        }
    }
    fun setMongo(){

    }

}


