package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.notification.exception.FailedUpdateException
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
            val string = creditCard.getNumber()
            val status = coll.updateOne("{idAccount:'${userAccount.getIdAccount()}'}", "{${addToSet}:{payment:'$string'}}")
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to update credit card! Matches: ${status.matchedCount} ")
            }
            addCreditCard(creditCard)
        }catch (e: Exception){
            throw e
        }
    }
    private fun addCreditCard(creditCard: CreditCard){
        val coll = getCollPayment()
        coll.insertOne(creditCard)
    }
}