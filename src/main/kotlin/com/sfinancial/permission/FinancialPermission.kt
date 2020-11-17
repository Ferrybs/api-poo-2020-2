package com.sfinancial.permission

import com.sfinancial.account.FinancialAccount
import com.sfinancial.admin.financialAdmin.RegisterFinancialAdmin
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.Financial
import com.sfinancial.login.LoginInterface

open class FinancialPermission(
        private val dbInterface: DBInterface
):ClassifierPermission(dbInterface) {
    fun createAccount(financial: Financial, idAdminInterface: IdAdminInterface){
        try {
            val financialAccount = FinancialAccount()
            RegisterFinancialAdmin(dbInterface).register(financialAccount, idAdminInterface)
        }catch (e:Exception){
            throw e
        }
    }
}