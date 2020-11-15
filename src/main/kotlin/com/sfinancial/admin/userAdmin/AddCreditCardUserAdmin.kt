package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CreditCard


class AddCreditCardUserAdmin(
    private val dbInterface: DBInterface
) {
    fun add(userAccount: UserAccount, creditCard: CreditCard) {
        try {

            dbInterface.insertNewCreditCard(userAccount,creditCard)
        } catch (e: Exception) {
            throw e
        }
    }
}