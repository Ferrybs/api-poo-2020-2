package com.sfinancial.admin.userAdmin

import com.sfinancial.database.DBInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class UpdateTransactionUserAdmin (
    private val dbInterface: DBInterface
) {
    fun update (creditCard: CreditCard,transaction: Transaction){
        try{
            dbInterface.updateTransaction(creditCard, transaction)
        }catch (e: Exception){
        throw e
    }
    }
}