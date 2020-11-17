package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CreditCard

class AddCategoryUserAdmin(
        private val dbInterface: DBInterface
) {
    fun add(userAccount: UserAccount,category: Category,idAdminInterface: IdAdminInterface){
        try {
            category.cId(idAdminInterface)
            dbInterface.insertNewCategory(userAccount,category)
        }catch (e: Exception){
            throw e
        }
    }
}