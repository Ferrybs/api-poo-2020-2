package com.sfinancial.admin.financialAdmin

import ClassifierAccount
import com.sfinancial.account.FinancialAccount
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface

class RegisterFinancialAdmin (
        private val dbInterface: DBInterface
) {
    fun register (financialAccount: FinancialAccount, idAdminInterface: IdAdminInterface){
        try {
            financialAccount.cId(idAdminInterface)
            dbInterface.insertNewFinancialAccount(financialAccount)

        }catch (e:Exception){
            throw e
        }

    }
}