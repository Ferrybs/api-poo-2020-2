package com.sfinancial.admin.financialAdmin

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.ClassifierLogin
import com.sfinancial.login.LoginInterface

class LoginFinancialAdmin(
        private val dbInterface: DBInterface
) {
    fun login(loginInterface: LoginInterface,authInterface: AuthInterface): String{
        try {
            val classifierAccount = dbInterface.getFinancialAccount(loginInterface)
            val user = classifierAccount.getFinancial()
            return authInterface.sign(ClassifierLogin(user.getUsername(),user.getPassword()))
        }catch (e: Exception){
            throw e
        }

    }
}