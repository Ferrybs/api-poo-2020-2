package com.sfinancial.permission

import ClassifierAccount
import com.sfinancial.admin.classifierAdmin.LoginClassifierAdmin
import com.sfinancial.admin.classifierAdmin.RegisterClassifierAdmin
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.Classifier
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.verifier.GroupVerifier
import com.sfinancial.verifier.LoginVerifier

open class ClassifierPermission(
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
    fun createAccount(classifier: Classifier,idAdminInterface: IdAdminInterface){
        try {
            if (GroupVerifier(classifier).verifier()) {
                val classifierAccount = ClassifierAccount(classifier)
                RegisterClassifierAdmin(dbInterface).register(classifierAccount,idAdminInterface)
            }
        }catch (e: Exception){
            throw e
        }

    }
}