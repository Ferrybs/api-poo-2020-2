package com.sfinancial.database.mongodb

import com.sfinancial.Account.AccountInterface
import com.sfinancial.database.DBInterface

open class MongoManagement(
        connectionString: String,
        databaseName: String,
) : MongoConnection(connectionString, databaseName), DBInterface {

    override fun registerAccount(accountInterface: AccountInterface) {
    }
}