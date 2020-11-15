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
    fun getUserAccount(loginInterface: LoginInterface): UserAccount
    fun insertNewCreditCard(userAccount: UserAccount, creditCard: CreditCard)
    fun getCreditCard(creditCardInterface: CardInterface)
    fun insertNewCategory(userAccount: UserAccount,category: Category)
    fun insertNewTransaction(userAccount: UserAccount,creditCard: CreditCard,transaction: Transaction)

    fun updateAddress(userAccount: UserAccount, address: Address)
}