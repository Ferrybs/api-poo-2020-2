package com.sfinancial.verifier

import com.sfinancial.payment.card.CardInterface
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
            cardInterface.getNumber()
            return true
        }catch (e: Exception){
            throw e
        }
    }
}