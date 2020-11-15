package com.sfinancial.call

import com.sfinancial.transaction.Transaction

class CallCreditCardTransaction(
        private val number: String,
        private val payment: Transaction,
){
    fun getNumber(): String {
        return number
    }
    fun getPayment(): Transaction {
        return payment
    }
}