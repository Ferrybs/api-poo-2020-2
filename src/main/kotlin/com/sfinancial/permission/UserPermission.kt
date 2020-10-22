package com.sfinancial.permission

import com.sfinancial.Account.AccountInterface
import com.sfinancial.login.LoginInterface

class UserPermission(
        val loginInterface: LoginInterface,
        val accountInterface: AccountInterface
): UserPermissionInterface {

    override fun registerAccount(){

    }
}