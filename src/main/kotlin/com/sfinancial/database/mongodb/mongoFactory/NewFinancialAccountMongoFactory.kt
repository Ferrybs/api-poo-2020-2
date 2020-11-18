package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.MongoException
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.FinancialAccount

class NewFinancialAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun add(financialAccount: FinancialAccount) {
        try {
            val coll = getCollFinancial()
            coll.insertOne(financialAccount)
        } catch (e: MongoException) {
            throw e
        } catch (e: Exception) {
            throw e
        }
    }
}