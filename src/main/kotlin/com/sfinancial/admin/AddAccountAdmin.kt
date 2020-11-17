package com.sfinancial.admin

import com.sfinancial.account.AdminAccount
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface

class AddAccountAdmin(
        private val dbInterface: DBInterface
) {
    fun add(adminAccount: AdminAccount,idAdminInterface: IdAdminInterface){
        try {
            adminAccount.cId(idAdminInterface)
            dbInterface.insertNewAdminAccount(adminAccount)
        }catch (e: Exception){
            throw e
        }
    }
}