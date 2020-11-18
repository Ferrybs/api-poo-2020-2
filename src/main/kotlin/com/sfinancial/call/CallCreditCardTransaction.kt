package com.sfinancial.call

import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class CallCreditCardTransaction(
        private val creditCard: CreditCard? = null,
        private val transaction: Transaction? = null,
){
    fun getCreditCard(): CreditCard {
        try {
            if (creditCard!=null){
                return creditCard
            }else{
                throw InvalidFieldsException("CreditCard is null")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun getTransaction(): Transaction {
        try {
            if (transaction!=null){
                return transaction
            }else{
                throw InvalidFieldsException("Transaction is null")
            }
        }catch (e: Exception){
            throw e
        }
    }
}