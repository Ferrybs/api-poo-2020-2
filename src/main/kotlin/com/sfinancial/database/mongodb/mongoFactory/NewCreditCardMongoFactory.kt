package com.sfinancial.database.mongodb.mongoFactory

import com.google.gson.Gson
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates
import com.sfinancial.account.UserAccount
import com.sfinancial.payment.card.CreditCard
import org.litote.kmongo.set
import org.litote.kmongo.util.KMongoUtil

class NewCreditCardMongoFactory(
    database: MongoDatabase
): MongoFactory(database) {
    private val gson = Gson()
    fun create(userAccount: UserAccount){
        val coll = getCollUserAccount()
        val bson = KMongoUtil.toBson(gson.toJson(userAccount.getPayment()))
        coll.updateOne(eq("{'idAccount':${userAccount.getIdAccount()}}"),Updates.addToSet("payment",bson))
    }
}