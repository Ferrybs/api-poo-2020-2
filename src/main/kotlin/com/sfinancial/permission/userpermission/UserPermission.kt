package com.sfinancial.permission.userpermission

import com.sfinancial.Account.AccountInterface
import com.sfinancial.Account.UserAccount
import com.sfinancial.admin.adminUser.AdminUserAccount
import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.verifier.VerifierUser
import kotlin.Exception

class UserPermission(
        private val groupInterface: GroupInterface? = null,
        private val accountInterface: AccountInterface? = null,
        private val dbInterface: DBInterface,
        private val configInterface: ConfigInterface

): UserPermissionInterface {

    override fun registerAccount(){
        try {
            if (VerifierUser(groupInterface).verifier()) {
                val userAccount = UserAccount(groupInterface)
                AdminUserAccount(userAccount, dbInterface,configInterface)
            }
        }catch (e: Exception){
            throw e
        }
    }
}