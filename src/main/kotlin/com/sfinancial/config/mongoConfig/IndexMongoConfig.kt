package com.sfinancial.config.mongoConfig

import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.IndexOptions
import com.sfinancial.account.UserAccount
import com.sfinancial.database.mongodb.ManagementMongodb
import org.litote.kmongo.createIndex
import org.litote.kmongo.getCollection


class IndexMongoConfig {
    private val database = getMongoDB()
    private val indexUnique = IndexOptions().unique(true)

    private fun getMongoDB(): MongoDatabase {
        try {
            val readMongoConfig = ReadMongoConfig()
            val connectionString = readMongoConfig.getConnectionString()
            val databaseName = readMongoConfig.getDatabaseName()
            return ManagementMongodb(connectionString,databaseName).getDatabase()
        }catch (e: Exception){
            throw e
        }
    }

    fun setUserAccount(){
        val coll = database.getCollection<UserAccount>()
        coll.createIndex("{'idAccount':1}",indexUnique)
        coll.createIndex("{'user.username':1}",indexUnique)
        coll.createIndex("{'user.person.document':1}",indexUnique)
        coll.createIndex("{'payment.number':1}",indexUnique)
    }
}