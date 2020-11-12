package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
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
           coll.updateOne(
                   "{idAccount:'${userAccount.getIdAccount()}'}",
                   "{${addToSet}:{category:$string}}")
       }catch (e: Exception){
           throw e
       }
    }
}