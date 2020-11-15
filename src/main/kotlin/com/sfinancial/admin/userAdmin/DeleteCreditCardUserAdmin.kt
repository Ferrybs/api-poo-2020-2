package com.sfinancial.admin.userAdmin

import com.sfinancial.database.DBInterface
import com.sfinancial.payment.card.CreditCard

class DeleteCreditCardUserAdmin(
    private val dbInterface: DBInterface
)
{
    fun delete (creditCard: CreditCard) {
        try {
            dbInterface.deleteCreditCard(creditCard)
        } catch (e: Exception) {
            throw e
        }
    }
}