package com.sfinancial.database.mongodb

import com.mongodb.client.MongoDatabase

open class MongoConnection(
        connectionString: String,
        private val databaseName: String
): Mongodb(connectionString){
    fun connect(): MongoDatabase {
        return client.getDatabase(databaseName)
    }
}