package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category

class UpdateCategoryMongoFactory(
        database: MongoDatabase
):MongoFactory(database){
    fun update(userAccount: UserAccount,category: Category){
        try{
           val coll = getCollUserAccount()
            TODO("NADA")
        }catch (e : Exception){
            throw e
        }
    }
}