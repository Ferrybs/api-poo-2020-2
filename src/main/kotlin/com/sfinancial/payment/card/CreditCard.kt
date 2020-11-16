package com.sfinancial.payment.card

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.transaction.Transaction

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class CreditCard(
        private val name: String? = null,
        private val number: String? = null,
        private val validity: String? = null,
        private val since: String? = null,
        private val cvv: String? = null
): CardInterface {
    private val transaction = mutableListOf<Transaction>()
    override fun verifier(): Boolean {
        return !listOf(
            name,
            number,
            validity,
            since,
            cvv
        ).any{it == null}
    }
    override fun getNumber():String {
        try {
            if (number != null){
                return number
            }else{
                throw InvalidFieldsException("Credit Card number is null!")
            }
        }catch (e: Exception){
            throw e
        }
    }
}