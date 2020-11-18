package com.sfinancial.call

import com.sfinancial.account.UserAccount
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class CallUserAccountTransaction(
        private val creditCard: CreditCard? = null,
        private val transaction: Transaction? = null
       ) {

    fun getTransaction(): Transaction {
        try {
            if(transaction != null){
                return transaction
            }else{
                throw InvalidFieldsException("Transaction is null!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun getCreditCard(): CreditCard {
        try {
            if(creditCard != null){
                return creditCard
            }else{
                throw InvalidFieldsException("Credit Card is null!")
            }
        }catch (e: Exception){
            throw e
        }
    }
}