package com.sfinancial.config.nettyConfig

class EnvNettyConfig: NettyConfigInterface {


    override fun getHost(): String {
        return try {
                System.getenv("cHost")
            }catch (e: Exception){
                throw e
            }
    }
    override fun getPort():Int{
        return try {
                System.getenv("PORT").toInt()
            }catch (e: Exception){
                throw e
            }
    }
}