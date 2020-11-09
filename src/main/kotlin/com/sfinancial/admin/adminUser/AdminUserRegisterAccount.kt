package com.sfinancial.admin.adminUser


import com.sfinancial.account.AccountUser
import com.sfinancial.database.DBInterface

class AdminUserRegisterAccount(
    private val userAccount: AccountUser,
    private val dbInterface: DBInterface,
) {
    fun registerAccount(){
        try {
            userAccount.cId()
            dbInterface.insertNewUserAccount(userAccount)
        }catch (e: Exception){
            throw e
        }
    }

}