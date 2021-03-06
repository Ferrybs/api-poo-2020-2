package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface

class UpdateCategoryUserAdmin(
    private val dbInterface: DBInterface
) {
    fun update(userAccount: UserAccount, category: Category){
        try {
            dbInterface.updateCategory(userAccount,category)
        }catch (e:  Exception){
            throw e
        }
    }
}