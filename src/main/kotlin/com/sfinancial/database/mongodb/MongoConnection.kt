package com.sfinancial.database.mongodb

import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase

open class MongoConnection(
        connectionString: String,
        private val databaseName: String
): Mongodb(connectionString){
    private val database = connection()
    private fun connection(): MongoDatabase{
        try {
            return client.getDatabase(databaseName)
        }catch (e: MongoException){
            throw e
        }catch (e: Exception){
            throw e
        }
    }
    fun connect(): MongoDatabase {
        try {
            return database
        }catch (e: Exception){
            throw e
        }
    }
}