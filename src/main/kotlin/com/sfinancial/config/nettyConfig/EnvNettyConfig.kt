package com.sfinancial.config.nettyConfig

class EnvNettyConfig: NettyConfigInterface {


    override fun getHost(): String {
        try {
                return System.getenv("cHost")
            }catch (e: Exception){
                throw e
            }
    }
    override fun getPort():Int{
        try {
            val port = System.getenv("PORT").toInt()
            return port
            }catch (e: Exception){
                throw e
            }
    }
}