package com.sfinancial.admin.adminUser


import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface

class AdminUserAccount(
        private val userAccount: UserAccount,
        private val dbInterface: DBInterface,
) {
    fun registerUser(){
        try {
            userAccount.cId()
        }catch (e: Exception){
            throw e
        }
    }

}