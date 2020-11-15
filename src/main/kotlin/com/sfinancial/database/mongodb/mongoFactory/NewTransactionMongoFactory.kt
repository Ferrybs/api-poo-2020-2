package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.updateOne

class NewTransactionMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {
    private val map = jacksonObjectMapper()
    fun add(userAccount: UserAccount,creditCard: CreditCard,transaction: Transaction){
        try {
            val string = map.writeValueAsString(transaction)
            val coll = getCollUserAccount()
            val res = coll.updateOne(
                    "{'payment':'${creditCard.getId()}'}",
                    "{${MongoOperator.addToSet}:{transaction:${string}}}")
            res.toString()
        }catch (e: Exception){
            throw e
        }

    }
}