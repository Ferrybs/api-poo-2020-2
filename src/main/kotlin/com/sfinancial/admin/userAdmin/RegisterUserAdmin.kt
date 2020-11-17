package com.sfinancial.admin.userAdmin


import com.sfinancial.account.UserAccount
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface

class RegisterUserAdmin(
        private val userAccount: UserAccount,
        private val dbInterface: DBInterface,
) {
    fun registerAccount(idAdminInterface: IdAdminInterface){
        try {
            userAccount.cId(idAdminInterface)
            dbInterface.insertNewAccountUser(userAccount)
        }catch (e: Exception){
            throw e
        }
    }

}