package com.sfinancial.permission.userpermission

import com.sfinancial.account.AccountInterface
import com.sfinancial.account.UserAccount
import com.sfinancial.admin.adminUser.AdminUserAccount
import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupInterface
import com.sfinancial.verifier.VerifierGroup
import kotlin.Exception

class UserPermission(
        private val groupInterface: GroupInterface? = null,
        private val accountInterface: AccountInterface? = null,
        private val dbInterface: DBInterface,

): UserPermissionInterface {

    override fun registerAccount(){
        try {
            if (VerifierGroup(groupInterface).verifier()) {
                val userAccount = UserAccount()
                AdminUserAccount(userAccount, dbInterface)
            }
        }catch (e: Exception){
            throw e
        }
    }
}