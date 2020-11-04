package com.sfinancial.config.readNettyConfig

interface ReadNettyConfigInterface {
    fun getConnectionString(): String
    fun getDatabaseName(): String
    fun getIssuer(): String
    fun getHost(): String
    fun getPort():Int
}