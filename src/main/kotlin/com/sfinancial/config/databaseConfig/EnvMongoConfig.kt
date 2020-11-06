package com.sfinancial.config.databaseConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class EnvMongoConfig: DatabaseConfigInterface {

    override fun getConnectionString(): String {
        return try {
                System.getenv("cString")
            }catch (e: Exception){
                throw e
            }
    }
    override fun getDatabaseName(): String{
        return try {
                System.getenv("dbName")
            }catch (e: Exception){
                throw e
            }
    }
}