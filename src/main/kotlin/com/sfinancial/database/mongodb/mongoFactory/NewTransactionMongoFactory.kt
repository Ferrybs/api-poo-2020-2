package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.updateOne
import org.litote.kmongo.MongoOperator.*

class NewTransactionMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {
    private val map = jacksonObjectMapper()
    fun add(creditCard: CreditCard,transaction: Transaction){
        try {
            val coll = getCollPayment()
            val string = map.writeValueAsString(transaction)
            val status = coll.updateOne("{number:'${creditCard.getId()}'}", "{${addToSet}:{transaction:$string}}")
        }catch (e: Exception){
            throw e
        }

    }
}