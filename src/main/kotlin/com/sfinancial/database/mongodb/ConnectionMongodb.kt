package com.sfinancial.database.mongodb

import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase
import com.sfinancial.database.DBInterface

open class ConnectionMongodb(
        connectionString: String,
        private val databaseName: String
): Mongodb(connectionString){
    private val database = connect()

    private fun connect(): MongoDatabase{
        try {
            val client = getClient()
            return client.getDatabase(databaseName)
        }catch (e: MongoException){
            throw e
        }catch (e: Exception){
            throw e
        }
    }
    fun getDatabase(): MongoDatabase {
        try {
            return database
        }catch (e: Exception){
            throw e
        }
    }
}