package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User

class UpdateUserUserAdmin (
        private val dbInterface: DBInterface
){
    fun update(user: User){
        try {
            dbInterface.updateUser(user)
        }catch (e: Exception){
            throw e
        }
    }

}