package com.sfinancial.admin.classifierAdmin

import ClassifierAccount
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.database.DBInterface

class RegisterClassifierAdmin(
        private val dbInterface: DBInterface
) {
    fun register(classifierAccount: ClassifierAccount, idAdminInterface: IdAdminInterface){
        try {
            classifierAccount.cId(idAdminInterface)
            dbInterface.insertNewClassifierAccount(classifierAccount)
        }catch (e: Exception){
            throw e
        }
    }
}