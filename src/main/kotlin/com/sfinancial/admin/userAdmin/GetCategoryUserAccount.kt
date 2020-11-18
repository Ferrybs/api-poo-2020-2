package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface

class GetCategoryUserAccount(
        private val dbInterface: DBInterface
) {
    fun get(userAccount: UserAccount): MutableList<Category>{
        try {
            val userAccountCategory = dbInterface.getUserAccount(userAccount)
            return userAccountCategory.getCategory()
        }catch (e : Exception){
            throw e
        }
    }
}