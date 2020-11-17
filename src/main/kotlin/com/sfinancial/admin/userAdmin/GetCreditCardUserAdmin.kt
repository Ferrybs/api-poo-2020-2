package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard

class GetCreditCardUserAdmin(
    private val dbInterface: DBInterface
) {
    fun get(creditCardInterface: CardInterface): CreditCard {
        try {
            return dbInterface.getCreditCard(creditCardInterface)

        }catch (e: Exception){
            throw e
        }
    }
}