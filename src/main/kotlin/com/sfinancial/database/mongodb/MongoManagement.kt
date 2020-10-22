package com.sfinancial.database.mongodb

import com.sfinancial.Account.AccountInterface
import com.sfinancial.database.DBInterface
import org.litote.kmongo.getCollection

open class MongoManagement(
        connectionString: String,
        databaseName: String,
) : MongoConnection(connectionString, databaseName), DBInterface {
    private val database = connect()

    override fun registerAccount(accountInterface: AccountInterface) {
        val col = database.getCollection<>()
        col.insertOne()
    }
}