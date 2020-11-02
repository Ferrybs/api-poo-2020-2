package com.sfinancial.database.mongodb

import com.sfinancial.Account.AccountInterface
import com.sfinancial.Account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.mongoFactory.UserAccountFactory

open class MongoManagement(
        connectionString: String,
        databaseName: String,
) : MongoConnection(connectionString, databaseName), DBInterface {

    private val database = connect()

    override fun registerUserAccount(userAccount: UserAccount) {
        try {
            UserAccountFactory(database,userAccount)
        }catch (e: Exception){
            throw e
        }
    }
}