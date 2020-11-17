package com.sfinancial.permission

import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.admin.userAdmin.*
import com.sfinancial.auth.AuthInterface
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.Person
import com.sfinancial.transaction.Transaction
import com.sfinancial.verifier.*
import kotlin.Exception

open class UserPermission(
        private val dbInterface: DBInterface
){
    fun createAccount(user: User,idAdminInterface: IdAdminInterface){
        try {
            if (GroupVerifier(user).verifier()) {
                val userAccount = UserAccount(user)
                RegisterUserAdmin(userAccount, dbInterface).registerAccount(idAdminInterface)
            }
        }catch (e: Exception){
            throw e
        }
    }
    open fun login(loginInterface: LoginInterface, authInterface: AuthInterface): String {
        try {
            if(LoginVerifier(loginInterface).verifier()){
                return LoginUserAdmin(loginInterface,dbInterface,authInterface).login()
            }else{
                throw FailedVerifierException("Filed to verify userLogin!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun getUserAccount(loginInterface: LoginInterface): UserAccount {
        try {
            if (LoginVerifier(loginInterface).verifier()){
                return GetUserAccountUserAdmin(dbInterface).getUserAccount(loginInterface)
            }
            throw FailedVerifierException("Failed to verify userLogin")
        }catch (e: Exception) {
            throw e
        }

    }

    fun createCreditCard(loginInterface: LoginInterface, creditCard: CreditCard){
        try {
            if (CardVerifier(creditCard).verifier() && LoginVerifier(loginInterface).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                AddCreditCardUserAdmin(dbInterface).add(user, creditCard)
            }else{
                throw FailedVerifierException("Failed to verifier credit card!")
            }
        }catch (e : Exception){
            throw e
        }
    }
    fun createCategory(loginInterface: LoginInterface,category: Category,idAdminInterface: IdAdminInterface){
        try {
            if(CategoryVerifier(category).verifier()&& LoginVerifier(loginInterface).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                AddCategoryUserAdmin(dbInterface).add(user,category,idAdminInterface)
            }else{
                throw FailedVerifierException("Failed to verifier category!")
            }
        }catch (e: Exception){
            throw e
        }
    }

    fun createTransaction(
            loginInterface: LoginInterface,
            callCreditCardTransaction: CallCreditCardTransaction,
            idAdminInterface: IdAdminInterface
    ){
        try {
            val creditCard = CreditCard(number = callCreditCardTransaction.getNumber())
            val transaction = callCreditCardTransaction.getPayment()
            if (
                    CardVerifier(creditCard).verifierId() &&
                    TransactionVerifier(transaction).verifier()&&
                    LoginVerifier(loginInterface).verifier()
            ){
                val userAccount = dbInterface.getUserAccount(loginInterface)
                val userCard = dbInterface.getUserAccount(creditCard)
                if (userAccount.getIdAccount() == userCard.getIdAccount()){
                    AddTransactionUserAdmin(dbInterface).add(
                            creditCard,
                            transaction,
                            idAdminInterface
                    )
                }else{
                    throw FailedFindException("Failed to match user!")
                }
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun updateTransaction(loginInterface: LoginInterface, transaction: Transaction){
        try{
            if (TransactionVerifier(transaction).verifier()&& LoginVerifier(loginInterface).verifier()){
                UpdateTransactionUserAdmin(dbInterface).update(transaction)
            }

        }catch (e: Exception){
        throw e
    }
    }
    fun updateCategory(loginInterface: LoginInterface,category: Category){
        try {
            if (LoginVerifier(loginInterface).verifier() && CategoryVerifier(category).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                UpdateCategoryUserAdmin(dbInterface).update(user,category)
            }else{
                throw FailedVerifierException("Failed to verifier category!")
            }
        }catch (e : Exception){
            throw e
        }
    }

    fun updateAddress(loginInterface: LoginInterface, address: Address){
        try {
            if (AddressVerifier(address).verifier()&& LoginVerifier(loginInterface).verifier())
            {
                val user = dbInterface.getUserAccount(loginInterface)
                UpdateAddressUserAdmin(dbInterface).update(user,address)
            }
        }catch (e:Exception){
            throw e
        }

    }

    fun deleteAddress(loginInterface: LoginInterface){
        try {
            if (LoginVerifier(loginInterface).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                DeleteAddressUserAdmin(dbInterface).delete(user)
            }
        }catch (e:Exception){
            throw e
        }
    }
    fun deleteCreditCard(loginInterface: LoginInterface,creditCard: CreditCard){
        try {
            if(CardVerifier(creditCard).verifierId() && LoginVerifier(loginInterface).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                val userCard = dbInterface.getUserAccount(creditCard)
                if(user.getIdAccount() == userCard.getIdAccount()){
                    DeleteCreditCardUserAdmin(dbInterface).delete(creditCard)
                }else{
                    throw FailedFindException ("Accounts does not match!")
                }
            }else{
                throw InvalidCredentialException("Invalid credential!")
            }
        }catch (e:Exception){
            throw e
        }
    }

    fun deleteCategory(loginInterface: LoginInterface,category: Category){
        try{
           if(CategoryVerifier(category).verifier()&& LoginVerifier(loginInterface).verifier()){
              val user = dbInterface.getUserAccount(loginInterface)
              DeleteCategoryUserAdmin(dbInterface).delete(user, category)
           }else{
               throw InvalidFieldsException("Failed to verify category")
           }
        }catch(e: Exception){
            throw e
        }
    }
    fun deleteTransaction(loginInterface: LoginInterface, transaction: Transaction){
        try {
            if (LoginVerifier(loginInterface).verifier()&&TransactionVerifier().verifierId()){
                val user = dbInterface.getUserAccount(loginInterface)
                val userCredit = dbInterface.getUserAccount(transaction)
                if (user.getIdAccount() == userCredit.getIdAccount()){
                    DeleteTransactionUserAdmin(dbInterface).delete(user, transaction)
                }else{
                    throw InvalidCredentialException("Invalid credential")
                }
            }

        }catch (e:Exception){
            throw e
        }
    }
    fun getCreditCard(loginInterface: LoginInterface, creditCard: CreditCard){
        try {
            if (LoginVerifier(loginInterface).verifier()&&CardVerifier(creditCard).verifierId()){
                val user = dbInterface.getUserAccount(loginInterface)
                val userCredit = dbInterface.getUserAccount(creditCard)
                if (user.getIdAccount() == userCredit.getIdAccount()){
                    GetCreditCardUserAdmin(dbInterface).get(creditCard)
                    //sql injection
                }else{
                    throw InvalidCredentialException("Credit Card does not match!")
                }
            }else{
                throw InvalidCredentialException("Invalid credential")
            }

        }catch (e:Exception){
            throw e
        }
    }
    fun updatePerson(loginInterface: LoginInterface, person: Person){
        try {
            if (PersonVerifier(person).verifier()&& LoginVerifier(loginInterface).verifier())
            {
                val user = dbInterface.getUserAccount(loginInterface)
                val personAccount = dbInterface.getUserAccount(person)
                if (user.getIdAccount() == personAccount.getIdAccount()){
                    UpdatePersonUserAdmin(dbInterface).update(user,person)
                    //sql injection
                }else{
                    throw InvalidCredentialException("Person does not match!")
                }
            }else{
            throw InvalidCredentialException("Invalid credential!")
        }
        }catch (e:Exception){
            throw e
        }

    }

    fun updateUser(loginInterface: LoginInterface, user: User){
        try {
            if(GroupVerifier(user).verifierGroup() && LoginVerifier(loginInterface).verifier()) {
                val userAccount = dbInterface.getUserAccount(loginInterface)
                val personAccount = dbInterface.getUserAccount(user)
                if (userAccount.getIdAccount() == personAccount.getIdAccount()) {
                    UpdateUserUserAdmin(dbInterface).update(user)
                    //sql injection
                } else {
                    throw InvalidCredentialException("Person does not match!")
                }
            }else {
                throw InvalidCredentialException("Invalid credential!")
            }
        }catch (e:Exception){
            throw e
        }
    }
}