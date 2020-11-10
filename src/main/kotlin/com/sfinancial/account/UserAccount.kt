package com.sfinancial.account

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.IdAdmin.UserIdAdmin
import com.sfinancial.category.Category
import com.sfinancial.group.UserGroup
import com.sfinancial.payment.card.CardCredit

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class UserAccount(
        private val userGroup: UserGroup? = null,
        private val category: MutableList<Category>? = mutableListOf(),
        private val payment: MutableList<CardCredit>? = mutableListOf()
): AccountInterface {
    private var idAccount: String? = null

    fun cId(){
        if (idAccount == null){
            try {
                idAccount = UserIdAdmin().create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    fun getUser(): UserGroup? {
        return userGroup
    }
}