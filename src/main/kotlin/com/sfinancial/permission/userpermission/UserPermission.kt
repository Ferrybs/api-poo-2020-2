package com.sfinancial.permission.userpermission

import com.sfinancial.account.AccountUser
import com.sfinancial.admin.adminUser.AdminUserRegisterAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupUser
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.ExceptionFailedVerifier
import com.sfinancial.verifier.VerifierGroup
import com.sfinancial.verifier.VerifierLogin
import kotlin.Exception

class UserPermission(
        private val dbInterface: DBInterface
){

    fun createAccount(groupUser: GroupUser){
        try {
            if (VerifierGroup(groupUser).verifier()) {
                val userAccount = AccountUser(groupUser)
                AdminUserRegisterAccount(userAccount, dbInterface).registerAccount()
            }
            throw ExceptionFailedVerifier("Failed to verify user!")
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