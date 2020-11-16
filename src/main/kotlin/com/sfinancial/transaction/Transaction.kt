package com.sfinancial.transaction

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.notification.exception.InvalidFieldsException

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Transaction(
        private val idTransaction: String?= null,
        private val date: String? = null,
        private val value: Double? = null,
        private val local: String? = null,
): TransactionInterface{
    override fun verifier(): Boolean{
        val hasNull = listOf(
                idTransaction,
                date,
                value,
                local
        ).any { it == null }

        return !hasNull
    }

    override fun getIdTransaction(): String {
        try {
            if (idTransaction != null){
                return idTransaction
            }else{
                throw InvalidFieldsException("Id transaction cannot be read")
            }
        }catch (e:Exception){
            throw e
        }
    }
}