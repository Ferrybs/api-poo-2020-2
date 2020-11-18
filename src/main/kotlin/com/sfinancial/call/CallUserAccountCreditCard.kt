package com.sfinancial.call

import com.sfinancial.account.UserAccount
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard

class CallUserAccountCreditCard(
        private val userAccount: UserAccount? = null,
        private val creditCard: CreditCard ? = null,
) {
    fun getUserAccount(): UserAccount {
        try {
            if(userAccount != null){
                return userAccount
            }else{
                throw InvalidFieldsException("UserAccount is null!")
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