package com.sfinancial.config.mongoConfig

interface MongoConfigInterface {
    fun getConnectionString(): String
    fun getDatabaseName(): String
}