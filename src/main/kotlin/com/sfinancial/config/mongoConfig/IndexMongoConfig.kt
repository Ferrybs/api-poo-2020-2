package com.sfinancial.config.mongoConfig

import ClassifierAccount
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.IndexOptions
import com.sfinancial.account.AdminAccount
import com.sfinancial.account.FinancialAccount
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
        coll.createIndex("{'category.name':1,'idAccount':1}",indexUnique)
    }
    fun setCreditCard(){
        val coll = database.getCollection<CreditCard>()
        coll.createIndex("{'number':1}",indexUnique)
        coll.createIndex("{'transaction.idTransaction':1}",indexUnique)
    }
    fun setClassifier(){
        val coll = database.getCollection<ClassifierAccount>()
        coll.createIndex("{'idAccount':1}",indexUnique)
        coll.createIndex("{'classifier.username':1}",indexUnique)
        coll.createIndex("{'classifier.person.idEmployee':1}",indexUnique)
    }
    fun setAdmin(){
        val coll = database.getCollection<AdminAccount>()
        coll.createIndex("{'idAccount':1}",indexUnique)
        coll.createIndex("{'admin.username':1}",indexUnique)
        coll.createIndex("{'admin.adminPerson.idEmployee':1}",indexUnique)
    }
    fun setFinancial(){
        val coll = database.getCollection<FinancialAccount>()
        coll.createIndex("{'idAccount':1}",indexUnique)
        coll.createIndex("{'financial.username':1}",indexUnique)
        coll.createIndex("{'financial.person.idEmployee':1}",indexUnique)
    }
}