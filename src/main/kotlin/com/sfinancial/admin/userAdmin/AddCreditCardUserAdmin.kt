package com.sfinancial.admin.userAdmin

import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CreditCard


class AddCreditCardUserAdmin(
    private val dbInterface: DBInterface
) {
    fun addCreditCard(loginInterface: LoginInterface, creditCard: CreditCard) {
        try {
            val user = dbInterface.getUserAccount(loginInterface)
            dbInterface.insertNewCreditCard(user,creditCard)
        } catch (e: Exception) {
            throw e
        }
    }
}