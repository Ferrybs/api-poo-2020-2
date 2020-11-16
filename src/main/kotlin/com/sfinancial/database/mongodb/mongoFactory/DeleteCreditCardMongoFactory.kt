package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.notification.exception.FailedDeleteException
import com.sfinancial.payment.card.CreditCard
import org.litote.kmongo.deleteOne

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
        }catch (e: Exception){
            throw e
        }
    }
}