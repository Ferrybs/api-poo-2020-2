package com.sfinancial.verifier

import com.sfinancial.database.DBInterface
import com.sfinancial.payment.card.CardInterface
import io.ktor.features.*
import kotlin.Exception

class CardVerifier(
    private val cardInterface: CardInterface
) {
    fun verifier(): Boolean {
        try {
        return cardInterface.verifier()
        }catch (e : Exception){
         throw e
        }
    }
    fun verifierId():Boolean{
        try {
            cardInterface.getId()
            return true
        }catch (e: Exception){
            throw e
        }
    }
    fun verifierUnique(dbInterface: DBInterface): Boolean{
        return try {
            dbInterface.getCreditCard(cardInterface)
            false
        }catch (e: NotFoundException){
            true
        }catch (e: Exception){
            throw e
        }
    }
}