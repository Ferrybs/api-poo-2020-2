package com.sfinancial.config.mongoConfig

import java.io.File

class ReadMongoConfig: MongoConfigInterface{
    override fun getConnectionString(): String {
        try{
            return File("connectionString.txt").readLines()[0]
        }catch (e: Exception){
            throw e
        }
    }
    override fun getDatabaseName(): String {
        try {
            return File("databaseName.txt").readLines()[0]
        }catch (e: Exception){
            throw e
        }
    }
}