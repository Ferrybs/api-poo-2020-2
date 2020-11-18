package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class DeleteTransactionUserAdmin (
    private val dbInterface: DBInterface
) {
    fun delete(transaction: Transaction){
        try {
            dbInterface.deleteTransaction(transaction)
        }catch (e:Exception){
            throw e
        }

    }
}