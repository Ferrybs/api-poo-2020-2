package com.sfinancial.config.nettyconfig

interface ConfigNettyInterface {
    fun getConnectionString(): String
    fun getDatabaseName(): String
    fun getSecretJwt():String
    fun getSecretHashid():String
    fun getIssuer(): String
    fun getHost(): String
    fun getPort():Int
}