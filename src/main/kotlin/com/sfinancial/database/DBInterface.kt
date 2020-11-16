package com.sfinancial.database

import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.category.Category
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction

interface DBInterface {
    fun insertNewAccountUser(userAccount: UserAccount)
    fun insertNewCreditCard(userAccount: UserAccount, creditCard: CreditCard)
    fun insertNewCategory(userAccount: UserAccount,category: Category)
    fun insertNewTransaction(creditCard: CreditCard,transaction: Transaction)
    fun getUserAccount(loginInterface: LoginInterface): UserAccount
    fun getUserAccount(creditCard: CreditCard): UserAccount
    fun getUserAccount(transaction: Transaction) : UserAccount
    fun getCreditCard(creditCardInterface: CardInterface): CreditCard
    fun updateCategory(userAccount: UserAccount,category: Category)
    fun updateAddress(userAccount: UserAccount, address: Address)
    fun updateTransaction(transaction: Transaction)
    fun deleteCreditCard(creditCard: CreditCard)
    fun deleteAddress(userAccount: UserAccount)
    fun deleteCategory(userAccount: UserAccount,category: Category)
    fun deleteTransaction(transaction: Transaction)
}