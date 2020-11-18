package com.sfinancial.database.mongodb

import ClassifierAccount
import com.sfinancial.account.AdminAccount
import com.sfinancial.account.FinancialAccount
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.mongoFactory.*
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.Person
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

    override fun getUserAccount(transaction: Transaction): UserAccount {
        try {
            return GetUserAccountMongoFactory(getDatabase()).get(transaction)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getUserAccount(person: Person): UserAccount {
        TODO("Not yet implemented")
    }

    override fun getUserAccount(user: User): UserAccount {
        TODO("Not yet implemented")
    }

    override fun getUserAccount(creditCard: CreditCard): UserAccount {
        try {
            return GetUserAccountMongoFactory(getDatabase()).get(creditCard)
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
    override fun updateTransaction(transaction: Transaction) {
        try {
            UpdateTransactionMongoFactory(getDatabase()).update(transaction)
        }catch (e: Exception){
            throw e
        }
    }

    override fun updateUserPerson(userAccount: UserAccount, person: Person) {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun deleteCreditCard(creditCard: CreditCard) {
        try {
            DeleteCreditCardMongoFactory(getDatabase()).delete(creditCard)
        }catch (e: Exception){
            throw e
        }
    }

    override fun deleteAddress(userAccount: UserAccount) {
        try {
            DeleteAddressMongoFactory(getDatabase()).delete(userAccount)
        }catch (e: Exception){
            throw e
        }
    }

    override fun deleteCategory(userAccount: UserAccount, category: Category) {
        try {
            DeleteCategoryMongoFactory(getDatabase()).delete(userAccount,category)
        }catch (e: Exception){
            throw e
        }
    }

    override fun deleteTransaction(transaction: Transaction) {
        try {
            DeleteTransactionMongoFactory(getDatabase()).delete(transaction)
        }catch (e: Exception){
            throw e
        }
    }

    override fun insertNewClassifierAccount(classifierAccount: ClassifierAccount) {
        try {
            NewClassifierAccountMongoFactory(getDatabase()).add(classifierAccount)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getClassifierAccount(): ClassifierAccount {
        TODO("Not yet implemented")
    }

    override fun insertNewFinancialAccount(financialAccount: FinancialAccount) {
        TODO("Not yet implemented")
    }

    override fun getFinancialAccount(): FinancialAccount {
        TODO("Not yet implemented")
    }

    override fun insertNewAdminAccount(adminAccount: AdminAccount) {
        try {
            NewAdminAccountMongoFactory(getDatabase()).add(adminAccount)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getAdminAccount(loginInterface: LoginInterface): AdminAccount {
        try {
            return GetAdminAccountMongoFactory(getDatabase()).get(loginInterface)
        }catch (e: Exception){
            throw e
        }
    }

}