package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.notification.exception.FailedUpdateException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import org.litote.kmongo.updateOne
import org.litote.kmongo.MongoOperator.*

class DeleteTransactionMongoFactory(
        database: MongoDatabase
) : MongoFactory(database){
    private val map = jacksonObjectMapper()
    fun delete(creditCard: CreditCard,transaction: Transaction){
        try {
            val coll = getCollPayment()
            val string = map.writeValueAsString(transaction)
            val status = coll.updateOne(
                    "{'number':'${creditCard.getNumber()}','transaction.idTransaction': '${transaction.getIdTransaction()}'}",
                    "{$pull:{'transaction': $string}}"
            )
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to delete transaction! Matches: ${status.matchedCount} ")
            }
        }catch (e: Exception){
            throw e
        }
    }
}