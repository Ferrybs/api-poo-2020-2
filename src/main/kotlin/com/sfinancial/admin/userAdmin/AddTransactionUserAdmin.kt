package com.sfinancial.admin.userAdmin

import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class AddTransactionUserAdmin(
        private val dbInterface: DBInterface
) {
    fun add(loginInterface: LoginInterface,creditCard: CreditCard,transaction: Transaction){
        try {
            val user = dbInterface.getUserAccount(loginInterface)
            dbInterface.insertNewTransaction(user,creditCard,transaction)
        }catch (e: Exception){
            throw e
        }
    }
}