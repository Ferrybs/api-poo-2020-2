package com.sfinancial.database.mongodb.mongoFactory

import ClassifierAccount
import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount

class NewClassifierAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun add(classifierAccount: ClassifierAccount){
        try {
            val coll = getCollClassifier()
            coll.insertOne(classifierAccount)
        }catch (e: MongoException){
            throw e
        }catch (e: Exception){
            throw e
        }
    }
}