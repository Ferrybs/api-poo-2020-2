package com.sfinancial.config.mongoConfig

interface mongoConfigInterface {
    fun getConnectionString(): String
    fun getDatabaseName(): String
}