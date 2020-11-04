package com.sfinancial.config.databaseConfig

interface DatabaseConfigInterface {
    fun getConnectionString(): String
    fun getDatabaseName(): String
}