package com.sfinancial.database.mongodb

import com.sfinancial.database.DBInterface

open class MongoManagement(
        connectionString: String,
        databaseName: String,
) : MongoConnection(connectionString, databaseName), DBInterface {
    val database = connect()
}