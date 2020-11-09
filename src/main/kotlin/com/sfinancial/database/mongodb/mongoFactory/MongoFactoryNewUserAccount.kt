package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.AccountUser

class MongoFactoryNewUserAccount(
        database: MongoDatabase
) : MongoFactory(database) {

    fun create(userAccount: AccountUser){
        try {
            val coll = getCollUserAccount()
            coll.insertOne(userAccount)
        }catch (e: MongoException){
            throw e
        }
    }
}