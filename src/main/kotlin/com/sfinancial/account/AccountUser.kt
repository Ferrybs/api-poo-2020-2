package com.sfinancial.account

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.adminID.AdminIdUser
import com.sfinancial.group.GroupUser
import com.sfinancial.payment.card.CardCredit

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class AccountUser(
    private val groupUser: GroupUser? = null,
    private val payment: MutableList<CardCredit> = mutableListOf()
): AccountInterface {
    var idAccount: String? = null

    fun cId(){
        if (idAccount == null){
            try {
                idAccount = AdminIdUser().create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    override fun getUser(): GroupUser? {
        return groupUser
    }
}