package com.sfinancial.config.mongoConfig

import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.IndexOptions
import com.sfinancial.account.AccountUser
import com.sfinancial.database.mongodb.MongoDbManagement
import org.litote.kmongo.createIndex
import org.litote.kmongo.getCollection


class MongoConfigIndex {
    private val database = getMongoDB()
    private val indexUnique = IndexOptions().unique(true)

    private fun getMongoDB(): MongoDatabase {
        try {
            val readMongoConfig = MongoConfigEnv()
            val connectionString = readMongoConfig.getConnectionString()
            val databaseName = readMongoConfig.getDatabaseName()
            return MongoDbManagement(connectionString,databaseName).getDatabase()
        }catch (e: Exception){
            throw e
        }
    }

    fun setUserAccount(){
        val coll = database.getCollection<AccountUser>()
        coll.createIndex("{'idAccount':1}",indexUnique)
        coll.createIndex("{'user.person.document':1}",indexUnique)
    }
}