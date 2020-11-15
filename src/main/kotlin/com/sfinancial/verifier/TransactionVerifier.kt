package com.sfinancial.verifier

import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.transaction.TransactionInterface

class TransactionVerifier(
        private val transactionInterface: TransactionInterface? = null
) {

    fun verifier():Boolean{
        try {
            if (transactionInterface != null && transactionInterface.verifier()){
                return true
            }else
            {
                throw InvalidFieldsException("Invalid Fields!")
            }
        }catch (e: Exception){
            throw e
        }
    }
}