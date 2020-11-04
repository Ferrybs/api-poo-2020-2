package com.sfinancial.admin.adminUser


import com.sfinancial.Account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupInterface

class AdminUserAccount(
        private val userAccount: UserAccount,
        private val dbInterface: DBInterface
) {
    fun register(){
        try {
            userAccount.cId()
            dbInterface.registerUserAccount(userAccount)
        }catch (e: Exception){
            throw e
        }
    }

}