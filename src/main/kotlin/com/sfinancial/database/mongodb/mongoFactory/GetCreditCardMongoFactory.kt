package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import io.ktor.features.*
import org.litote.kmongo.findOne
import kotlin.Exception

class GetCreditCardMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun get(creditCardInterface: CardInterface): CreditCard {
        try {
            val coll = getCollPayment()
            val card =coll.findOne("{'number': '${creditCardInterface.getNumber()}'}")
            if (card != null){
                return card
            }else{
                throw NotFoundException("CreditCard not Found!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun get(transaction: Transaction): CreditCard {
        try {
            val coll = getCollPayment()
            val card = coll.findOne(
                    "{'transaction.idTransaction': '${transaction.getIdTransaction()}'}"
            )
            if (card != null){
                return card
            }else{
                throw NotFoundException("CreditCard not Found!")
            }
        }catch (e: Exception){
            throw e
        }
    }
}