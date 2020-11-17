package com.sfinancial.config.mongoConfig

import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.IndexOptions
import com.sfinancial.account.UserAccount
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.payment.card.CreditCard
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
            return StrategyMongodb(connectionString,databaseName).getDatabase()
        }catch (e: Exception){
            throw e
        }
    }

    fun setUserAccount(){
        val coll = database.getCollection<UserAccount>()
        coll.createIndex("{'idAccount':1}",indexUnique)
        coll.createIndex("{'user.username':1}",indexUnique)
        coll.createIndex("{'user.person.document':1}",indexUnique)
        coll.createIndex("{'idAccount':1,'category.name':1}",indexUnique)
    }
    fun setCreditCard(){
        val coll = database.getCollection<CreditCard>()
        coll.createIndex("{'number':1}",indexUnique)
        coll.createIndex("{'transaction.idTransaction':1}",indexUnique)
        coll.createIndex("{'number':1,'transaction.idTransaction':1}",indexUnique)
    }
}