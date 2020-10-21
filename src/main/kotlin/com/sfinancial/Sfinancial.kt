package com.sfinancial

import com.sfinancial.server.ServerInterface

internal data class Sfinancial(
        private val server: ServerInterface,
){
    fun startServer() {
        server.start()
    }

}


