package com.sfinancial.config.nettyConfig

interface NettyConfigInterface {
    fun getConnectionString(): String
    fun getDatabaseName(): String
    fun getIssuer(): String
    fun getHost(): String
    fun getPort():Int
}