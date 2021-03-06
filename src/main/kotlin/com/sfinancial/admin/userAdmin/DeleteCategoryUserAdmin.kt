package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface

class DeleteCategoryUserAdmin(
        private val dbInterface: DBInterface
) {
    fun delete(userAccount: UserAccount,category: Category){
        try{
            dbInterface.deleteCategory(userAccount, category)
        }catch(e :Exception){
            throw e
        }
    }
}