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

    override fun getCreditCard(transaction: Transaction): CreditCard {
        try {
            return GetCreditCardMongoFactory(getDatabase()).get(transaction)
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
        try {
            return GetUserAccountMongoFactory(getDatabase()).get(person)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getUserAccount(user: User): UserAccount {
        try {
            return GetUserAccountMongoFactory(getDatabase()).get(user)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getUserAccount(userAccount: UserAccount): UserAccount {
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

    override fun updateUserPerson(person: Person) {
        try {
            UpdatePersonMongoFactory(getDatabase()).update(person)
        }catch (e: Exception){
            throw e
        }
    }

    override fun updateUser(user: User) {
        try {
            UpdateUserMongoFactory(getDatabase()).update(user)
        }catch (e: Exception){
            throw e
        }
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

    override fun getClassifierAccount(loginInterface: LoginInterface): ClassifierAccount {
        try {
            return GetClassifierAccountMongoFactory(getDatabase()).get(loginInterface)
        }catch (e: Exception){
            throw e
        }
    }

    override fun insertNewFinancialAccount(financialAccount: FinancialAccount) {
        try {
            NewFinancialAccountMongoFactory(getDatabase()).add(financialAccount)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getFinancialAccount(loginInterface: LoginInterface): FinancialAccount {
        try {
            return GetFinancialAccountMongoFactory(getDatabase()).get(loginInterface)
        }catch (e: Exception){
            throw e
        }
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