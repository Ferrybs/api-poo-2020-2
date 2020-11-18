package com.sfinancial.permission

import com.sfinancial.account.AdminAccount
import com.sfinancial.admin.AddAccountAdmin
import com.sfinancial.admin.GetAdminAccount
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.Admin
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.verifier.GroupVerifier
import com.sfinancial.verifier.LoginVerifier

class AdminPermission(
        private val dbInterface: DBInterface
) : FinancialPermission(dbInterface){
    fun createAccount(loginInterface: LoginInterface,admin: Admin,dbInterface: DBInterface,idAdminInterface: IdAdminInterface) {
        try {
            if(LoginVerifier(loginInterface).verifier() && GroupVerifier(admin).verifier()){
                dbInterface.getAdminAccount(loginInterface)
                val adminAccount = AdminAccount(admin)
                AddAccountAdmin(dbInterface).add(adminAccount,idAdminInterface)
            }else{
                throw FailedVerifierException("Failed to verify Admin account!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun login(loginInterface: LoginInterface, authInterface: AuthInterface):String{
        try {
            if (LoginVerifier(loginInterface).verifier()){
                return GetAdminAccount(dbInterface).get(loginInterface,authInterface)
            }else{
                throw FailedVerifierException("Failed to verifier login!")
            }
        }catch (e: Exception){
            throw e
        }
    }
}