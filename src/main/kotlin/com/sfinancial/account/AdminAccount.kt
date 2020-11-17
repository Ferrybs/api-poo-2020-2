package com.sfinancial.account

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.group.Admin
import com.sfinancial.group.Classifier
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.FailedUpdateException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.person.AdminPerson

class AdminAccount(
        private val admin: Admin? = null
){
    private var idAccount: String? = null

    fun cId(idAdminInterface: IdAdminInterface){
        try {
            if (idAccount == null){
                idAccount = idAdminInterface.create(12)
            }else{
                throw FailedUpdateException("idAccount is not null!")
            }
        }catch (e: Exception){
            throw e
        }

    }

    fun getAdmin(): Admin {
        try {
            if (admin != null){
                return admin
            }
            throw FailedFindException("Admin is null!")
        }catch (e: Exception){
            throw e
        }
    }

    fun getIdAccount(): String {
        try {
            if (idAccount != null){
                return idAccount.toString()
            }else{
                throw InvalidFieldsException("Account has no id!")
            }
        }catch (e : Exception){
            throw e
        }
    }
}
