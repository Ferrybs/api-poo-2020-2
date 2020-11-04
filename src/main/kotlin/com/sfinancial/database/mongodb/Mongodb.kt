package com.sfinancial.database.mongodb

import com.mongodb.MongoException
import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo


abstract class Mongodb(
        private val connectionString: String,
){
     private val client = connectClient()

     private fun connectClient():MongoClient{
          try {
              return KMongo.createClient(connectionString)
          }catch (e: MongoException){
               throw e
          }catch (e: Exception){
               throw e
          }
     }
     fun getConnectionStatus(): Boolean {
          try {
              val status = client.clusterDescription.shortDescription
               val idx = status.indexOf("CONNECTED")
               return idx >=0
          }catch (e: MongoException){
               throw e
          }catch (e: Exception){
               throw e
          }
     }

     fun getClient(): MongoClient{
          return client
     }
}