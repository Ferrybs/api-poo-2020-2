package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

class AddTransactionUserAdmin(
        private val dbInterface: DBInterface
) {
    fun add(creditCard: CreditCard,transaction: Transaction,idAdminInterface: IdAdminInterface){
        try {
            transaction.cIdTransaction(idAdminInterface)
            dbInterface.insertNewTransaction(creditCard,transaction)
        }catch (e: Exception){
            throw e
        }
    }
}