package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface

class GetUserAccountUserAdmin(
    private val dbInterface: DBInterface
) {
    fun getUserAccount(loginInterface: LoginInterface): UserAccount {
        try {
            return dbInterface.getUserAccount(loginInterface)

        }catch (e: Exception){
            throw e
        }
    }
}