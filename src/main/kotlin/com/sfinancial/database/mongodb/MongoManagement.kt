package com.sfinancial.database.mongodb

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.mongoFactory.NewUserAccount

open class MongoManagement(
        connectionString: String,
        databaseName: String,
) : MongoConnection(connectionString, databaseName), DBInterface {

    override fun insertNewUserAccount(userAccount: UserAccount) {
        try {
            NewUserAccount(getDatabase()).create(userAccount)
        }catch (e: Exception){
            throw e
        }
    }
}