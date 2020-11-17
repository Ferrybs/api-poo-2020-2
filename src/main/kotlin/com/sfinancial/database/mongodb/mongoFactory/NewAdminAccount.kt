package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.AdminAccount

class NewAdminAccount(
        database: MongoDatabase
) : MongoFactory(database){
    fun add(adminAccount: AdminAccount){
        try {
            val coll = getCollAdmin()
            coll.insertOne(adminAccount)
        }catch (e: Exception){
            throw e
        }
    }
}