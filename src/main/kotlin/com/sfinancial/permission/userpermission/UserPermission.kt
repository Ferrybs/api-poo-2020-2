package com.sfinancial.permission.userpermission

import com.sfinancial.Account.AccountInterface
import com.sfinancial.Account.UserAccount
import com.sfinancial.group.GroupInterface
import com.sfinancial.login.LoginInterface
import com.sfinancial.verifier.VerifierUser

class UserPermission(
        private val groupInterface: GroupInterface? = null,
        private val accountInterface: AccountInterface? = null
): UserPermissionInterface {

    override fun registerAccount(){
        try {
            if (VerifierUser(groupInterface).verifier()){
                
            }
        }
    }
}