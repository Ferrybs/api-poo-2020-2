package com.sfinancial.permission

import com.sfinancial.admin.classifierAdmin.LoginClassifierAdmin
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.verifier.LoginVerifier

class ClassifierPermission(
        private val dbInterface: DBInterface
) : UserPermission(dbInterface){

    override fun login(loginInterface: LoginInterface, authInterface: AuthInterface): String {
        try {
            if (LoginVerifier(loginInterface).verifier()){
                return LoginClassifierAdmin(dbInterface).login(loginInterface,authInterface)
            }else{
                throw FailedVerifierException("Failed to verify userLogin!")
            }
        }catch (e:Exception){
            throw e
        }
    }
}