package com.sfinancial.account

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.adminHasid.AdminUserHashid
import com.sfinancial.group.User
import com.sfinancial.payment.Payment
import com.sfinancial.payment.card.CreditCard

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class UserAccount(
        private val user: User? = null,
        private val payment: CreditCard? = null,
): AccountInterface {
    var idAccount: String? = null

    fun cId(){
        if (idAccount == null){
            try {
                idAccount = AdminUserHashid().create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    override fun getUser(): User? {
        return user
    }
}