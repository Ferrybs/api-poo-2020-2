package com.sfinancial.admin.classifierAdmin

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.ClassifierLogin
import com.sfinancial.login.LoginInterface

class LoginClassifierAdmin(
        private val dbInterface: DBInterface
) {
    fun login(loginInterface: LoginInterface,authInterface: AuthInterface): String{
        try {
            val classifierAccount = dbInterface.getClassifierAccount()
            val user = classifierAccount.getClassifier()
            return authInterface.sign(ClassifierLogin(user.getUsername(),user.getPassword()))
        }catch (e: Exception){
            throw e
        }

    }
}