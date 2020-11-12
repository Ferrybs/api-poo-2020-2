package com.sfinancial.admin.userAdmin

import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CreditCard

class AddCategoryUserAdmin(
        private val dbInterface: DBInterface
) {
    fun add(loginInterface: LoginInterface,category: Category){
        try {
            val user = dbInterface.getUserAccount(loginInterface)
            dbInterface.insertNewCategory(user,category)
        }catch (e: Exception){
            throw e
        }
    }
}