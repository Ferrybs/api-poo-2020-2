package com.sfinancial.database.mongodb

import org.litote.kmongo.KMongo


abstract class Mongodb(
        private val connectionString: String,
){
     val client = KMongo.createClient(connectionString)
}