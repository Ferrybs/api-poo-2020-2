package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.Account.UserAccount

class NewUserAccount(
        database: MongoDatabase
) : MongoFactory(database) {

    fun create(userAccount: UserAccount){
        try {
            val coll = getCollUserAccount()
            coll.insertOne(userAccount)
        }catch (e: Exception){
            throw e
        }
    }
}