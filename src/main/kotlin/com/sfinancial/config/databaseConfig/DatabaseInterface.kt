package com.sfinancial.config.databaseConfig

interface DatabaseInterface {
    fun getConnectionString(): String
    fun getDatabaseName(): String
}