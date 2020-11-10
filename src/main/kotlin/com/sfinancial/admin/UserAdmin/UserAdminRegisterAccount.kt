package com.sfinancial.admin.UserAdmin


import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface

class UserAdminRegisterAccount(
        private val userAccount: UserAccount,
        private val dbInterface: DBInterface,
) {
    fun registerAccount(){
        try {
            userAccount.cId()
            dbInterface.insertNewAccountUser(userAccount)
        }catch (e: Exception){
            throw e
        }
    }

}