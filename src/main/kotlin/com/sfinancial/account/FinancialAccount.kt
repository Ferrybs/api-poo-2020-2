package com.sfinancial.account

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.group.Classifier
import com.sfinancial.group.Financial
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.FailedUpdateException
import com.sfinancial.notification.exception.InvalidFieldsException

class FinancialAccount(
        private val financial: Financial? = null
) {
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

    fun getFinancial(): Financial {
        try {
            if (financial != null){
                return financial
            }
            throw FailedFindException("Financial is null!")
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
}