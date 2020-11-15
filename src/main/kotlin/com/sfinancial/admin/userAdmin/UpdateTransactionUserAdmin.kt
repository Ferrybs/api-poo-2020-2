package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.transaction.Transaction

class UpdateTransactionUserAdmin (
    private val dbInterface: DBInterface
) {
    fun update (number: String, transaction: Transaction){
        try{
            dbInterface.updateTransaction(number,transaction)
        }catch (e: Exception){
        throw e
    }
    }
}