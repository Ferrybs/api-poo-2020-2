package com.sfinancial.permission

import com.sfinancial.account.UserAccount
import com.sfinancial.admin.userAdmin.AddCreditCardUserAdmin
import com.sfinancial.admin.userAdmin.GetUserAccountUserAdmin
import com.sfinancial.admin.userAdmin.LoginAccountUserAdmin
import com.sfinancial.admin.userAdmin.RegisterAccountUserAdmin
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.verifier.CardVerifier
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
                RegisterAccountUserAdmin(userAccount, dbInterface).registerAccount()
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
                return LoginAccountUserAdmin(loginInterface,dbInterface,authInterface).login()
            }
            throw FailedVerifierException("Filed to verify login!")
        }catch (e: Exception){
            throw e
        }
    }
    fun getUserAccount(loginInterface: LoginInterface): UserAccount {
        try {
            return GetUserAccountUserAdmin(dbInterface).getUserAccount(loginInterface)
        }catch (e: Exception) {
            throw e
        }

    }

    fun createCreditCard(loginInterface: LoginInterface, creditCard: CreditCard){
        try {
            val verifier = CardVerifier(creditCard)
            if (verifier.verifier()){
                if (verifier.verifierUnique(dbInterface)){
                    AddCreditCardUserAdmin(dbInterface).addCreditCard(loginInterface, creditCard)
                }else{
                    throw  FailedVerifierException("Credit Card is not unique!")
                }
            }else{
                throw FailedVerifierException("Failed to verifier!")
            }
        }catch (e : Exception){
            throw e
        }
    }
}

