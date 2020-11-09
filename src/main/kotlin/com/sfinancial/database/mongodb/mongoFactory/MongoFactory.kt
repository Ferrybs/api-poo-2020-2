package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.MongoException
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.AccountUser
import com.sfinancial.notification.exception.ExceptionFailedReturnCollection
import org.litote.kmongo.getCollection

open class MongoFactory(
        private val database: MongoDatabase,
) {

    internal fun getCollUserAccount(): MongoCollection<AccountUser> {
        try {
            return database.getCollection<AccountUser>()
        }catch (e: MongoException){
            throw ExceptionFailedReturnCollection(e.message)
        }
    }
}