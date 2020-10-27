package com.sfinancial.database.mongodb

import com.mongodb.MongoClientException
import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase

open class MongoConnection(
        connectionString: String,
        private val databaseName: String
): Mongodb(connectionString){
    fun connect(): MongoDatabase {
        try {
            return client.getDatabase(databaseName)
        }catch (e: MongoException){
            throw e
        }catch (e: Exception){
            throw e
        }
    }
}