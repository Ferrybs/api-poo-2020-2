package com.sfinancial.permission

import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.admin.userAdmin.*
import com.sfinancial.auth.AuthInterface
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import com.sfinancial.verifier.*
import javax.security.auth.login.FailedLoginException
import kotlin.Exception

class UserPermission(
        private val dbInterface: DBInterface
){
    fun createAccount(user: User){
        try {
            if (GroupVerifier(user).verifier()) {
                val userAccount = UserAccount(user)
                RegisterUserAdmin(userAccount, dbInterface).registerAccount()
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun login(loginInterface: LoginInterface, authInterface: AuthInterface): String {
        try {
            if(LoginVerifier(loginInterface).verifier()){
                return LoginUserAdmin(loginInterface,dbInterface,authInterface).login()
            }else{
                throw FailedVerifierException("Filed to verify login!")
            }
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
                val user = dbInterface.getUserAccount(loginInterface)
                AddCreditCardUserAdmin(dbInterface).add(user, creditCard)
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
                val userAccount = dbInterface.getUserAccount(loginInterface)
                val userCard = dbInterface.getPaymentAccount(creditCard.getId())
                if (userAccount.getIdAccount() == userCard.getIdAccount()){
                    AddTransactionUserAdmin(dbInterface).add(creditCard,transaction)
                }else{
                    throw FailedFindException("Failed to match user!")
                }
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun updateTransaction(loginInterface: LoginInterface, callCreditCardTransaction: CallCreditCardTransaction){
        try{
            val number = callCreditCardTransaction.getNumber()
            val transaction = callCreditCardTransaction.getPayment()
            if (TransactionVerifier(transaction).verifier()){
                UpdateTransactionUserAdmin(dbInterface).update(number, transaction)
            }

        }catch (e: Exception){
        throw e
    }
    }

    fun updateAddress(loginInterface: LoginInterface, address: Address){
        try {
            if (AddressVerifier(address).verifier())
            {
                val user = dbInterface.getUserAccount(loginInterface)
                UpdateAddressUserAdmin(dbInterface).update(user,address)
            }
        }catch (e:Exception){
            throw e
        }

    }

    fun deleteAddress(loginInterface: LoginInterface, address: Address){
        try {
            if (AddressVerifier(address).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                DeleteAddressUserAdmin(dbInterface).delete(user, address)
            }
        }catch (e:Exception){
            throw e
        }
    }







    fun deleteCreditCard(loginInterface: LoginInterface,creditCard: CreditCard){
        try {
            if(CardVerifier(creditCard).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                val usercard = dbInterface.getPaymentAccount(creditCard.getId())
                if(user.getIdAccount() == usercard.getIdAccount()){
                    DeleteCreditCardUserAdmin(dbInterface).delete(creditCard)
                }
                throw InvalidCredentialException ("Invalid Credential !!")
            }
        }catch (e:Exception){
            throw e
        }
    }

    fun deleteCategory(loginInterface: LoginInterface,category: Category){
        try{
           if(CategoryVerifier(category).verifier()){
              val user = dbInterface.getUserAccount(loginInterface)
              DeleteCategoryUserAdmin(dbInterface).delete(user, category)
           }
        }catch(e: Exception){
            throw e
        }
    }
}

