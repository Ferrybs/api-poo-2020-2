package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.notification.exception.FailedDeleteException
import com.sfinancial.notification.exception.FailedUpdateException
import com.sfinancial.payment.card.CreditCard
import org.litote.kmongo.deleteOne
import org.litote.kmongo.updateOne
import org.litote.kmongo.MongoOperator.*

class DeleteCreditCardMongoFactory(
        database: MongoDatabase
) : MongoFactory(database){

    fun delete(creditCard: CreditCard){
        try {
            val coll = getCollPayment()
            val status =coll.deleteOne("{'number':'${creditCard.getNumber()}'}")
            if (status.deletedCount.toInt()==0){
                throw FailedDeleteException("Failed to delete credit card:  ${status.toString()}")
            }
            deletePayment(creditCard)
        }catch (e: Exception){
            throw e
        }
    }
    private fun deletePayment(creditCard: CreditCard){
        try {
            val coll = getCollUserAccount()
            val status = coll.updateOne(
                    "{'payment':'${creditCard.getNumber()}'}",
                    "{${pull}:{'payment': '${creditCard.getNumber()}'}}"
            )
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to delete payment! Matches: ${status.matchedCount} ")
            }
        }catch (e: Exception){
            throw e
        }
    }
}