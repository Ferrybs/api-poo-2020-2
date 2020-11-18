package com.sfinancial.admin

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.AdminLogin
import com.sfinancial.login.LoginInterface
import com.sfinancial.verifier.LoginVerifier

class GetAdminAccount(
        private val dbInterface: DBInterface
) {
    fun get(loginInterface: LoginInterface,authInterface: AuthInterface): String {
        try {
            val adminAccount = dbInterface.getAdminAccount(loginInterface)
            val admin = adminAccount.getAdmin()
            return authInterface.sign(AdminLogin(admin.getUsername(),admin.getPassword()))
        }catch (e: Exception){
            throw e
        }
    }
}