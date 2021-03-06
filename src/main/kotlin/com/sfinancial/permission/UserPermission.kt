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
                throw FailedVerifierException("Failed to verify credit card!")
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
                throw FailedVerifierException("Failed to verify category!")
            }
        }catch (e: Exception){
            throw e
        }
    }

    open fun createTransaction(
            loginInterface: LoginInterface,
            callCreditCardTransaction: CallCreditCardTransaction,
            idAdminInterface: IdAdminInterface
    ){
        try {
            val creditCard = callCreditCardTransaction.getCreditCard()
            val transaction = callCreditCardTransaction.getTransaction()
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
    open fun updateTransaction(
            loginInterface: LoginInterface,
            callCreditCardTransaction: CallCreditCardTransaction
    ){
        try{
            val transaction = callCreditCardTransaction.getTransaction()
            val creditCard = callCreditCardTransaction.getCreditCard()
            if (TransactionVerifier(transaction).verifier()&& LoginVerifier(loginInterface).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                val userCredit = dbInterface.getUserAccount(creditCard)
                if (user.getIdAccount() == userCredit.getIdAccount()){
                    UpdateTransactionUserAdmin(dbInterface).update(creditCard,transaction)
                }else{
                    throw InvalidCredentialException("Invalid Credential")
                }
            }else{
                throw FailedVerifierException("Failed to update transaction!")
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
                throw FailedVerifierException("Failed to verify category!")
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
            }else{
                throw FailedVerifierException("Failed to verify category!!")
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
    open fun deleteCreditCard(loginInterface: LoginInterface, creditCard: CreditCard){
        try {
            if(CardVerifier(creditCard).verifierId() && LoginVerifier(loginInterface).verifier()){
                val user = dbInterface.getUserAccount(loginInterface)
                val userCard = dbInterface.getUserAccount(creditCard)
                if(user.getIdAccount() == userCard.getIdAccount()){
                    DeleteCreditCardUserAdmin(dbInterface).delete(creditCard)
                }else{
                    throw FailedFindException ("Credit card not found!")
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
               throw InvalidFieldsException("Failed to verify category!")
           }
        }catch(e: Exception){
            throw e
        }
    }
    open fun deleteTransaction(loginInterface: LoginInterface, callCreditCardTransaction: CallCreditCardTransaction){
        try {
            val transaction = callCreditCardTransaction.getTransaction()
            val creditCard = callCreditCardTransaction.getCreditCard()
            if (
                    LoginVerifier(loginInterface).verifier()&&
                    TransactionVerifier().verifierId() &&
                    CardVerifier(creditCard).verifierId()
            ){
                val user = dbInterface.getUserAccount(loginInterface)
                val userCredit = dbInterface.getUserAccount(creditCard,transaction)
                if (user.getIdAccount() == userCredit.getIdAccount()){
                    DeleteTransactionUserAdmin(dbInterface).delete(creditCard,transaction)
                }else{
                    throw InvalidCredentialException("Invalid credential")
                }
            }

        }catch (e:Exception){
            throw e
        }
    }
    open fun getCreditCard(loginInterface: LoginInterface, creditCard: CreditCard): CreditCard {
        try {
            if (LoginVerifier(loginInterface).verifier()&&CardVerifier(creditCard).verifierId()){
                val user = dbInterface.getUserAccount(loginInterface)
                val userCredit = dbInterface.getUserAccount(creditCard)
                if (user.getIdAccount() == userCredit.getIdAccount()){
                    return GetCreditCardUserAdmin(dbInterface).get(creditCard)
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
                    UpdatePersonUserAdmin(dbInterface).update(person)
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
                    UpdateUserAdmin(dbInterface).update(user)
                    //sql injection
                } else {
                    throw InvalidCredentialException("User does not match!")
                }
            }else {
                throw InvalidCredentialException("Invalid credential!")
            }
        }catch (e:Exception){
            throw e
        }
    }
    open fun getTransaction(loginInterface: LoginInterface, callCreditCardTransaction: CallCreditCardTransaction): CreditCard {
        try {
            val transaction = callCreditCardTransaction.getTransaction()
            val creditCard = callCreditCardTransaction.getCreditCard()
            if (LoginVerifier(loginInterface).verifier()&&TransactionVerifier(transaction).verifierId()){
                val user = dbInterface.getUserAccount(loginInterface)
                val userTransaction = dbInterface.getUserAccount(creditCard,transaction)
                if (user.getIdAccount() == userTransaction.getIdAccount()){
                    return GetTransactionUserAccount(dbInterface).get(creditCard,transaction)
                    //sql injection
                }else{
                    throw InvalidCredentialException("Transaction does not match!")
                }
            }else{
                throw InvalidCredentialException("Invalid credential")
            }

        }catch (e:Exception){
            throw e
        }
    }
}