package com.sfinancial.permission

import ClassifierAccount
import com.sfinancial.admin.classifierAdmin.LoginClassifierAdmin
import com.sfinancial.admin.classifierAdmin.RegisterClassifierAdmin
import com.sfinancial.admin.financialAdmin.LoginFinancialAdmin
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.admin.userAdmin.AddCategoryUserAdmin
import com.sfinancial.admin.userAdmin.DeleteCategoryUserAdmin
import com.sfinancial.admin.userAdmin.GetCategoryUserAccount
import com.sfinancial.auth.AuthInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.group.Classifier
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.verifier.CategoryVerifier
import com.sfinancial.verifier.GroupVerifier
import com.sfinancial.verifier.LoginVerifier

open class ClassifierPermission(
        private val dbInterface: DBInterface
) : UserPermission(dbInterface){

    override fun login(loginInterface: LoginInterface, authInterface: AuthInterface): String {
        try {
            if (LoginVerifier(loginInterface).verifier()){
                return LoginFinancialAdmin(dbInterface).login(loginInterface,authInterface)
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
            }else
            {
                throw FailedVerifierException("Failed to verify classifier!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun createCategory(loginInterface: LoginInterface,
                       callUserAccountCategory: CallUserAccountCategory,
                       idAdminInterface: IdAdminInterface
    ){
        try {
            dbInterface.getClassifierAccount(loginInterface)
            val userAccount = callUserAccountCategory.getUserAccount()
            val category = callUserAccountCategory.getCategory()
            if (CategoryVerifier(category).verifier()){
                AddCategoryUserAdmin(dbInterface).add(userAccount,category,idAdminInterface)
            }else{
                throw FailedVerifierException("Failed to verify category!")
            }
        }catch (e: Exception){
            throw e
        }
    }

    fun deleteCategory(loginInterface: LoginInterface,callUserAccountCategory: CallUserAccountCategory) {
        try {
            dbInterface.getClassifierAccount(loginInterface)
            val userAccount = callUserAccountCategory.getUserAccount()
            val category = callUserAccountCategory.getCategory()
            if(CategoryVerifier(category).verifierId()){
                DeleteCategoryUserAdmin(dbInterface).delete(userAccount, category)
            }else{
                throw FailedVerifierException("Failed to verify category!")
            }
        }catch (e:Exception){
            throw e
        }
    }

    fun getCategory(loginInterface: LoginInterface,
                    callUserAccountCategory: CallUserAccountCategory
    ): MutableList<Category>{
        try {
            dbInterface.getClassifierAccount(loginInterface)
            val userAccount = callUserAccountCategory.getUserAccount()
            val category = callUserAccountCategory.getCategory()
            if (CategoryVerifier(category).verifierId()){
                return GetCategoryUserAccount(dbInterface).get(userAccount, category)
            }else{
                throw FailedVerifierException("Failed to verify category!")
            }
        }catch (e : Exception){
            throw e
        }
    }
}