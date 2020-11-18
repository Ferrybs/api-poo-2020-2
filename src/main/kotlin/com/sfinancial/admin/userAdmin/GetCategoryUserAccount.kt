package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface

class GetCategoryUserAccount(
        private val dbInterface: DBInterface
) {
    fun get(userAccount: UserAccount, category: Category): MutableList<Category>{
        try {
            val userAccount = dbInterface.getUserAccount(userAccount)
            return userAccount.getCategory()
        }catch (e : Exception){
            throw e
        }
    }
}