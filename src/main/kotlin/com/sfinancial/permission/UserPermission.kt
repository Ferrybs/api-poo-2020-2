package com.sfinancial.permission

import com.sfinancial.account.UserAccount
import com.sfinancial.admin.userAdmin.*
import com.sfinancial.auth.AuthInterface
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import com.sfinancial.verifier.*
import kotlin.Exception

class UserPermission(
        private val dbInterface: DBInterface
){
    fun createAccount(groupUser: User){
        try {
            if (GroupVerifier(groupUser).verifier()) {
                val userAccount = UserAccount(groupUser)
                RegisterUseAdmin(userAccount, dbInterface).registerAccount()
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
                return LoginUserAdmin(loginInterface,dbInterface,authInterface).login()
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
                    AddCreditCardUserAdmin(dbInterface).add(loginInterface, creditCard)
                }else{
                    throw  FailedVerifierException("Credit Card has already been registered!")
                }
            }else{
                throw FailedVerifierException("Failed to verifier!")
            }
        }catch (e : Exception){
            throw e
        }
    }
    fun createCategory(loginInterface: LoginInterface,category: Category){
        try {
            if(CategoryVerifier(category).verifier()){
                AddCategoryUserAdmin(dbInterface).add(loginInterface,category)
            }else{
                throw FailedVerifierException("Failed to verifier!")
            }
        }catch (e: Exception){
            throw e
        }
    }

    fun createTransaction(loginInterface: LoginInterface,callCreditCardTransaction: CallCreditCardTransaction){
        try {
            val creditCard = CreditCard(number = callCreditCardTransaction.getNumber())
            val transaction = callCreditCardTransaction.getPayment()
            if (CardVerifier(creditCard).verifierId() && TransactionVerifier(transaction).verifier()){
                AddTransactionUserAdmin(dbInterface).add(loginInterface,creditCard,transaction)
            }
        }catch (e: Exception){
            throw e
        }
    }
}

