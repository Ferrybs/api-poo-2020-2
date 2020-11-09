package com.sfinancial.database.mongodb

import com.sfinancial.account.AccountUser
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.mongoFactory.MongoFactoryNewUserAccount

open class MongoDbManagement(
        connectionString: String,
        databaseName: String,
) : MongoDbConnection(connectionString, databaseName), DBInterface {

    override fun insertNewUserAccount(userAccount: AccountUser) {
        try {
            MongoFactoryNewUserAccount(getDatabase()).create(userAccount)
        }catch (e: Exception){
            throw e
        }
    }
}