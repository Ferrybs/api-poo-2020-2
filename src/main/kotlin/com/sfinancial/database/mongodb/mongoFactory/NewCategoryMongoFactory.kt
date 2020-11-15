package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.notification.exception.FailedUpdateException
import org.litote.kmongo.MongoOperator.*
import org.litote.kmongo.updateOne
import kotlin.Exception

class NewCategoryMongoFactory(
        database: MongoDatabase
):MongoFactory(database) {
    private val map = jacksonObjectMapper()

    fun add(userAccount: UserAccount,category: Category){
       try {
           val string = map.writeValueAsString(category)
           val coll = getCollUserAccount()
           val status = coll.updateOne(
                   "{idAccount:'${userAccount.getIdAccount()}'}",
                   "{${addToSet}:{category:$string}}")
           if(status.modifiedCount.toInt()==0){
               throw FailedUpdateException("Failed to update! Matches: ${status.matchedCount} ")
           }
       }catch (e: Exception){
           throw e
       }
    }
}