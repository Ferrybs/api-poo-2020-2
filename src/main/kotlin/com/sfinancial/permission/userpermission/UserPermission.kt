package com.sfinancial.permission.userpermission

import com.sfinancial.account.UserAccount
import com.sfinancial.admin.adminUser.AdminUserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupInterface
import com.sfinancial.group.User
import com.sfinancial.verifier.VerifierGroup
import kotlin.Exception

class UserPermission(
        private val user: User? = null,
        private val dbInterface: DBInterface
){

    fun createAccount(){
        try {
            if (VerifierGroup(user).verifier()) {
                val userAccount = UserAccount(user)
                AdminUserAccount(userAccount, dbInterface).registerAccount()
            }
        }catch (e: Exception){
            throw e
        }
    }
}