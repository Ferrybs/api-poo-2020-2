package com.sfinancial.admin.userAdmin

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.login.Login

class LoginUserAdmin(
        private val loginInterface: LoginInterface,
        private val dbInterface: DBInterface,
        private val authInterface: AuthInterface
) {
    fun login(): String {
        try {
            val accountUser = dbInterface.getUserAccount(loginInterface)
            val user = accountUser.getUser()
            val login = Login(user.getUsername(),user.getPassword())
            return authInterface.sign(login)
        }catch (e: Exception){
            throw e
        }
    }
}