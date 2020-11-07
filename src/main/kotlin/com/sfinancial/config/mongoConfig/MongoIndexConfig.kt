package com.sfinancial.config.mongoConfig

import com.google.gson.Gson
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.IndexOptions
import com.mongodb.client.model.Indexes
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.database.mongodb.MongoManagement
import com.sfinancial.group.User
import com.sfinancial.person.Person
import org.bson.Document
import org.litote.kmongo.getCollection
import org.litote.kmongo.util.KMongoUtil
import javax.jws.soap.SOAPBinding

class MongoIndexConfig {
    private val database = getMongoDB()
    private val indexUnique = IndexOptions().unique(true)

    private fun getMongoDB(): MongoDatabase {
        try {
            val readMongoConfig = EnvMongoConfig()
            val connectionString = readMongoConfig.getConnectionString()
            val databaseName = readMongoConfig.getDatabaseName()
            return MongoManagement(connectionString,databaseName).getDatabase()
        }catch (e: Exception){
            throw e
        }
    }

    fun setUserAccount(){
        val coll = database.getCollection<UserAccount>()
        coll.createIndex(Indexes.ascending("idAccount"),indexUnique)
        //coll.createIndex(Indexes.ascending("document"),indexUnique)
        //coll.createIndex(Indexes.ascending("lastName"))
    }
    fun testUserAccount(){
        val coll = database.getCollection<UserAccount>()

        val address = Address(
                "test",
                "test",
                "test",
                "test",
                "test",
                "test"
        )
        val person = Person(
                "test",
                "test",
                "test",
                "test",
                address
        )
        val user = User(
                "test",
                "test",
            person
        )
        val userAccount = UserAccount(user)
        userAccount.idAccount = "testee"

        coll.insertOne(userAccount)
    }
}