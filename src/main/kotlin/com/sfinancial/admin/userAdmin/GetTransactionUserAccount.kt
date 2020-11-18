package com.sfinancial.admin.userAdmin

import com.sfinancial.database.DBInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class GetTransactionUserAccount(
        private val dbInterface: DBInterface
) {
    fun get(transaction: Transaction): CreditCard{
        try {
            return dbInterface.getCreditCard(transaction)
        }catch (e: Exception){
            throw e
        }
    }
}