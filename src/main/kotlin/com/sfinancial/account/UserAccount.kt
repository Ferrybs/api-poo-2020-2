package com.sfinancial.account

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.idAdmin.UserIdAdmin
import com.sfinancial.category.Category
import com.sfinancial.group.User
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class UserAccount(
        private val user: User? = null,
): AccountInterface {
    private var idAccount: String? = null
    private val category: MutableList<Category> = mutableListOf()
    private val payment: MutableList<String> =  mutableListOf()

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

    fun getIdAccount(): String? {
        try {
            if (idAccount != null){
                return idAccount
            }else{
                throw InvalidFieldsException("Account has no id!")
            }
        }catch (e : Exception){
            throw e
        }
    }
}