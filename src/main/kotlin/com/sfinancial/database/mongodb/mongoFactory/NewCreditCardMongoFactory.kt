package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.payment.card.CreditCard
import org.litote.kmongo.MongoOperator.*
import org.litote.kmongo.updateOne

class NewCreditCardMongoFactory(
    database: MongoDatabase
): MongoFactory(database) {
    private val map = jacksonObjectMapper()
    fun add(userAccount: UserAccount, creditCard: CreditCard){
        try {
            val coll = getCollUserAccount()
            val string = map.writeValueAsString(creditCard)
            coll.updateOne("{idAccount:'${userAccount.getIdAccount()}'}", "{${addToSet}:{payment:$string}}")
        }catch (e: Exception){
            throw e
        }
        }
}