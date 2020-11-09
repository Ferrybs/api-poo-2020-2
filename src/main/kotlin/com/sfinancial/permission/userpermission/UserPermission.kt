package com.sfinancial.permission.userpermission

import com.sfinancial.account.UserAccount
import com.sfinancial.admin.adminUser.RegisterUserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifier
import com.sfinancial.verifier.VerifierGroup
import com.sfinancial.verifier.VerifierLogin
import kotlin.Exception

class UserPermission(
        private val dbInterface: DBInterface
){

    fun createAccount(user: User){
        try {
            if (VerifierGroup(user).verifier()) {
                val userAccount = UserAccount(user)
                RegisterUserAccount(userAccount, dbInterface).registerAccount()
            }
            throw FailedVerifier("Failed to verify user!")
        }catch (e: Exception){
            throw e
        }
    }
    fun login(loginInterface: LoginInterface){
        try {
            if(VerifierLogin(loginInterface).verifier()){

            }
        }catch (e: Exception){
            throw e
        }
    }
}