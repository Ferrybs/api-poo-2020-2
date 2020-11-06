package com.sfinancial.admin.adminUser


import com.sfinancial.account.UserAccount
import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.DBInterface

class AdminUserAccount(
        private val userAccount: UserAccount,
        private val dbInterface: DBInterface,
        private val configInterface: ConfigInterface
) {
    fun registerUser(){
        try {
            userAccount.cId(configInterface)
        }catch (e: Exception){
            throw e
        }
    }

}