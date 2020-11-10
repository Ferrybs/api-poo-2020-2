package com.sfinancial.account

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.idAdmin.UserIdAdmin
import com.sfinancial.category.Category
import com.sfinancial.group.User
import com.sfinancial.payment.card.CreditCard

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class UserAccount(
        private val user: User? = null,
): AccountInterface {
    private var idAccount: String? = null
    private val category: MutableList<Category> = mutableListOf()
    private val payment: MutableList<CreditCard> =  mutableListOf()

    fun cId(){
        if (idAccount == null){
            try {
                idAccount = UserIdAdmin().create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    fun getUser(): User? {
        return user
    }
}