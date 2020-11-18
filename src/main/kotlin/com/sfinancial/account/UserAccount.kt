package com.sfinancial.account

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.category.Category
import com.sfinancial.group.User
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.FailedUpdateException
import com.sfinancial.notification.exception.InvalidFieldsException

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class UserAccount(
        private val user: User? = null,
) {
    private var idAccount: String? = null
    private val category: MutableList<Category> = mutableListOf()
    private val payment: MutableList<String> =  mutableListOf()

    fun cId(idAdminInterface: IdAdminInterface){
        try {
            if (idAccount == null){
                idAccount = idAdminInterface.create(8)
            }else{
                throw FailedUpdateException("idAccount is not null!")
            }
        }catch (e: Exception){
            throw e
        }

    }

    fun getUser(): User {
        try {
            if (user != null){
                return user
            }
            throw FailedFindException("User is null!")
        }catch (e: Exception){
            throw e
        }
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

    fun getCategory(): MutableList<Category> {
        try {
            if (category != null){
                return category
            }else{
                throw InvalidFieldsException("Category has no id!")
            }
        }catch (e : Exception){
            throw e
        }

    }
}