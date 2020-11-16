package com.sfinancial.database.mongodb

import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.mongoFactory.*
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

open class StrategyMongodb(
        connectionString: String,
        databaseName: String,
) : ConnectionMongodb(connectionString, databaseName), DBInterface {

    override fun insertNewAccountUser(userAccount: UserAccount) {
        try {
            NewUserAccountMongoFactory(getDatabase()).add(userAccount)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getUserAccount(loginInterface: LoginInterface): UserAccount {
        try {
            return GetUserAccountMongoFactory(getDatabase()).get(loginInterface)
        }catch (e: Exception){
            throw e
        }
    }

    override fun insertNewCreditCard(userAccount: UserAccount,creditCard: CreditCard) {
        try {
            NewCreditCardMongoFactory(getDatabase()).add(userAccount,creditCard)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getCreditCard(creditCardInterface: CardInterface): CreditCard {
        try {
            return GetCreditCardMongoFactory(getDatabase()).get(creditCardInterface)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getPaymentAccount(number: String): UserAccount {
        try {
            return GetUserPaymentMongoFactory(getDatabase()).get(number)
        }catch (e: Exception){
            throw e
        }
    }

    override fun insertNewCategory(userAccount: UserAccount, category: Category) {
        try {
            NewCategoryMongoFactory(getDatabase()).add(userAccount,category)
        }catch (e: Exception){
            throw e
        }
    }

    override fun insertNewTransaction(creditCard: CreditCard, transaction: Transaction) {
        try {
            NewTransactionMongoFactory(getDatabase()).add(creditCard,transaction)
        }catch (e: Exception){
            throw e
        }
    }

    override fun updateCategory(userAccount: UserAccount, category: Category) {
        try {
            UpdateCategoryMongoFactory(getDatabase()).update(userAccount,category)
        }catch (e: Exception){
            throw e
        }
    }

    override fun updateAddress(userAccount: UserAccount, address: Address) {
        try {
            UpdateAddressMongoFactory(getDatabase()).update(userAccount,address)
        }catch (e: Exception){
            throw e
        }
    }
    override fun updateTransaction(number: String, transaction: Transaction) {

    }

    override fun deleteCreditCard(creditCard: CreditCard) {
        TODO("Not yet implemented")
    }

    override fun deleteAddress(userAccount: UserAccount, address: Address) {
        TODO("Not yet implemented")
    }

    override fun deleteCategory(userAccount: UserAccount, category: Category) {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(userAccount: UserAccount, transaction: Transaction) {
        TODO("Not yet implemented")
    }
}