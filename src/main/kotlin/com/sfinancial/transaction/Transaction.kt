package com.sfinancial.transaction

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.notification.exception.InvalidFieldsException

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Transaction(
        private val date: String? = null,
        private val value: Double? = null,
        private val local: String? = null,
): TransactionInterface{
    private var idTransaction: String?= null
    override fun verifier(): Boolean{
        val hasNull = listOf(
                date,
                value,
                local
        ).any { it == null }

        return !hasNull
    }

    override fun cIdTransaction(idAdminInterface: IdAdminInterface) {
        try {
            if (idTransaction == null){
                idTransaction = idAdminInterface.create(10)
            }else
            {
                throw InvalidFieldsException("idTransaction is not null!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun getIdTransaction(): String {
        try {
            if (idTransaction != null){
                return idTransaction.toString()
            }else{
                throw InvalidFieldsException("Id transaction cannot be read")
            }
        }catch (e:Exception){
            throw e
        }
    }
}