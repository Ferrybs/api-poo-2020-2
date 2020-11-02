package com.sfinancial.permission.userpermission

import com.sfinancial.Account.AccountInterface
import com.sfinancial.login.LoginInterface

class UserPermission(
        val loginInterface: LoginInterface? = null,
        val accountInterface: AccountInterface? = null
): UserPermissionInterface {

    override fun registerAccount(){

    }
}