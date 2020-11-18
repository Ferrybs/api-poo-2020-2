package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class DeleteTransactionUserAdmin (
    private val dbInterface: DBInterface
) {
    fun delete(creditCard: CreditCard,transaction: Transaction){
        try {
            dbInterface.deleteTransaction(creditCard,transaction)
        }catch (e:Exception){
            throw e
        }

    }
}