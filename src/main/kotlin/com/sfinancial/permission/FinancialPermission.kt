package com.sfinancial.permission

import com.sfinancial.account.FinancialAccount
import com.sfinancial.account.UserAccount
import com.sfinancial.admin.financialAdmin.RegisterFinancialAdmin
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.admin.userAdmin.*
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.call.CallUserAccountCreditCard
import com.sfinancial.call.CallUserAccountTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.group.Financial
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import com.sfinancial.verifier.CardVerifier
import com.sfinancial.verifier.CategoryVerifier
import com.sfinancial.verifier.TransactionVerifier

open class FinancialPermission(
        private val dbInterface: DBInterface
):ClassifierPermission(dbInterface) {
    fun createAccount(loginInterface: LoginInterface,financial: Financial, idAdminInterface: IdAdminInterface){
        try {
            dbInterface.getAdminAccount(loginInterface)
            val financialAccount = FinancialAccount(financial)
            RegisterFinancialAdmin(dbInterface).register(financialAccount, idAdminInterface)
        }catch (e:Exception){
            throw e
        }
    }
    fun createCreditCard(
            loginInterface: LoginInterface,
            callUserAccountCreditCard: CallUserAccountCreditCard
    ){
        try {
            dbInterface.getFinancialAccount(loginInterface)
            val userAccount = callUserAccountCreditCard.getUserAccount()
            val creditCard = callUserAccountCreditCard.getCreditCard()
            if (CardVerifier(creditCard).verifier()){
                AddCreditCardUserAdmin(dbInterface).add(userAccount,creditCard)
            }else{
                throw FailedVerifierException("Failed to verify category!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun createTransaction(
            loginInterface: LoginInterface,
            callUserAccountTransaction: CallUserAccountTransaction,
            idAdminInterface: IdAdminInterface
    ){
        try {
            dbInterface.getFinancialAccount(loginInterface)
            val transaction = callUserAccountTransaction.getTransaction()
            val creditCard = callUserAccountTransaction.getCreditCard()
            if (TransactionVerifier(transaction).verifier() && CardVerifier(creditCard).verifierId()){
                AddTransactionUserAdmin(dbInterface).add(creditCard,transaction,idAdminInterface)
            }else{
                throw FailedVerifierException("Failed to verify transaction!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun deleteCreditCard(
            loginInterface: LoginInterface,
            creditCard: CreditCard
    ){
        try {
            dbInterface.getFinancialAccount(loginInterface)
            if (CardVerifier(creditCard).verifierId()){
                DeleteCreditCardUserAdmin(dbInterface).delete(creditCard)
            }else{
                throw FailedVerifierException("Failed to verify credit card!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun deleteTransaction(
            loginInterface: LoginInterface,
            callCreditCardTransaction: CallCreditCardTransaction,
                ){
        try {
            val transaction = callCreditCardTransaction.getTransaction()
            val creditCard = callCreditCardTransaction.getCreditCard()
            dbInterface.getFinancialAccount(loginInterface)
            if (TransactionVerifier(transaction).verifierId()&&CardVerifier(creditCard).verifierId()){
                DeleteTransactionUserAdmin(dbInterface).delete(creditCard,transaction)
            }else{
                throw FailedVerifierException("Failed to verify transaction!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun getTransaction(
            loginInterface: LoginInterface,
            callCreditCardTransaction: CallCreditCardTransaction
    ): CreditCard {
        try {
            val transaction = callCreditCardTransaction.getTransaction()
            val creditCard = callCreditCardTransaction.getCreditCard()
            dbInterface.getFinancialAccount(loginInterface)
            if (TransactionVerifier(transaction).verifierId()){
            return GetTransactionUserAccount(dbInterface).get(creditCard,transaction)
            }else{
                throw FailedVerifierException("Failed to verify transaction!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun updateTransaction(
            loginInterface: LoginInterface,
            callCreditCardTransaction: CallCreditCardTransaction
    ){
        try {
            val creditCard = callCreditCardTransaction.getCreditCard()
            val transaction = callCreditCardTransaction.getTransaction()
            dbInterface.getFinancialAccount(loginInterface)
            if (TransactionVerifier(transaction).verifier()&& CardVerifier(creditCard).verifierId()){
                UpdateTransactionUserAdmin(dbInterface).update(creditCard,transaction)
            }else{
                throw FailedVerifierException("Failed to verify transaction!")
            }
        }catch (e : Exception){
            throw e
        }
    }
    override fun getCreditCard(
            loginInterface: LoginInterface,
            creditCard: CreditCard
    ): CreditCard {
        try {
            dbInterface.getFinancialAccount(loginInterface)
            if (CardVerifier(creditCard).verifierId()){
                return GetCreditCardUserAdmin(dbInterface).get(creditCard)
            }else{
                throw InvalidFieldsException("Invalid Credit Card")
            }
        }catch (e: Exception){
            throw e
        }
    }



}
