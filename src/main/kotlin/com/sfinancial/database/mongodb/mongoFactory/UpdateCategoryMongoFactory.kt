package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.notification.exception.FailedUpdateException
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.updateOne
import org.litote.kmongo.MongoOperator.*
import org.litote.kmongo.set

class UpdateCategoryMongoFactory(
        database: MongoDatabase
):MongoFactory(database){
    private val map = jacksonObjectMapper()
    fun update(userAccount: UserAccount,category: Category){
        try{
           val coll = getCollUserAccount()
            val string= map.writeValueAsString(category)
            val status = coll.updateOne(
                    "{'idAccount':'${userAccount.getIdAccount()}', 'category.idCategory': '${category.getIdCategory()}'}",
                    "{${set}:{'category.$':$string}}"
            )
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to update category! Matches: ${status.matchedCount} ")
            }
        }catch (e : Exception){
            throw e
        }
    }
}