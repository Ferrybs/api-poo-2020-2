package com.sfinancial.permission

import com.sfinancial.account.UserAccount
import com.sfinancial.admin.userAdmin.UserAdminLoginAccount
import com.sfinancial.admin.userAdmin.UserAdminRegisterAccount
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.verifier.GroupVerifier
import com.sfinancial.verifier.LoginVerifier
import kotlin.Exception

class UserPermission(
        private val dbInterface: DBInterface
){

    fun createAccount(groupUser: User){
        try {
            if (GroupVerifier(groupUser).verifier()) {
                val userAccount = UserAccount(groupUser)
                UserAdminRegisterAccount(userAccount, dbInterface).registerAccount()
            }else{
                throw FailedVerifierException("Failed to verify user!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun login(loginInterface: LoginInterface, authInterface: AuthInterface): String {
        try {
            if(LoginVerifier(loginInterface).verifier()){
                return UserAdminLoginAccount(loginInterface,dbInterface,authInterface).login()
            }
            throw FailedVerifierException("Filed to verify login!")
        }catch (e: Exception){
            throw e
        }
    }
}