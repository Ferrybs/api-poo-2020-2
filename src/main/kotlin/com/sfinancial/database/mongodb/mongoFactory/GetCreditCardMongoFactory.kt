package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard
import io.ktor.features.*
import org.litote.kmongo.find
import org.litote.kmongo.findOne
import kotlin.Exception

class GetCreditCardMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun get(creditCardInterface: CardInterface): CreditCard {
        try {
            val coll = getCollPayment()
            val card =coll.findOne("{'number': ${creditCardInterface.getId()}}")
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