package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.MongoException
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.sfinancial.Account.UserAccount
import org.litote.kmongo.getCollection

class UserAccountFactory(
        val database: MongoDatabase,
        val userAccount: UserAccount
) {
    private fun getCollection(): MongoCollection<UserAccount> {
        try {
            return database.getCollection<UserAccount>()
        }catch (e: MongoException){
            throw e
        }
    }

    fun create(){
        try {
            val col = getCollection()
            col.insertOne(userAccount)
        }catch (e: MongoException){
            throw e
        }

    }

}