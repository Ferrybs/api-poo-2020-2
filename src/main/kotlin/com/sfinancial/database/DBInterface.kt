package com.sfinancial.database

import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard

interface DBInterface {
    fun insertNewAccountUser(userAccount: UserAccount)
    fun getUserAccount(loginInterface: LoginInterface): UserAccount
    fun insertNewCreditCard(userAccount: UserAccount, creditCard: CreditCard)
    fun getCreditCard(creditCardInterface: CardInterface)
    fun insertNewCategory(userAccount: UserAccount,category: Category)

}