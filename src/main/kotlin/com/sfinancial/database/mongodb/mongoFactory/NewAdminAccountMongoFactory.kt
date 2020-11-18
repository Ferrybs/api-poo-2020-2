package com.sfinancial.database.mongodb.mongoFactory

import ClassifierAccount
import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.AdminAccount
import com.sfinancial.account.UserAccount
import com.sfinancial.group.Admin

class NewAdminAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun add(adminAccount: AdminAccount){
        try {
            val coll = getCollAdmin()
            coll.insertOne(adminAccount)
        }catch (e: MongoException){
            throw e
        }catch (e: Exception){
            throw e
        }
    }
}