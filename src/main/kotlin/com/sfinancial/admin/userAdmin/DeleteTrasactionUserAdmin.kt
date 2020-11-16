package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.transaction.Transaction

class DeleteTrasactionUserAdmin (
    private val dbInterface: DBInterface
) {
    fun delete(userAccount: UserAccount, transaction: Transaction){
        try {
            dbInterface.deleteTransaction(transaction)
        }catch (e:Exception){
            throw e
        }

    }
}