package com.sfinancial.admin.adminUser


import com.sfinancial.Account.UserAccount
import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupInterface

class AdminUserAccount(
        private val userAccount: UserAccount,
        private val dbInterface: DBInterface,
        private val configInterface: ConfigInterface
) {
    fun register(){
        try {
            userAccount.cId(configInterface)
        }catch (e: Exception){
            throw e
        }
    }

}