package com.sfinancial.database

import com.sfinancial.account.UserAccount
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CreditCard

interface DBInterface {
    fun insertNewAccountUser(userAccount: UserAccount)
    fun getUserAccount(loginInterface: LoginInterface): UserAccount
    fun insertNewCreditCard(userAccount: UserAccount, creditCard: CreditCard)

}