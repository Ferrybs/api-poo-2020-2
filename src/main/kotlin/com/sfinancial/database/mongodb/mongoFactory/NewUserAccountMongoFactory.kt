package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount

class NewUserAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun add(userAccount: UserAccount){
        try {
            val coll = getCollUserAccount()
            coll.insertOne(userAccount)
        }catch (e: MongoException){
            throw e
        }catch (e: Exception){
            throw e
        }
    }
}