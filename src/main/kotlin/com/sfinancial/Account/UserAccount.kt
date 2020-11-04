package com.sfinancial.Account

import com.sfinancial.admin.adminID.AdminIDInterface
import com.sfinancial.admin.adminID.UserID
import com.sfinancial.group.GroupInterface
import com.sfinancial.group.User

class UserAccount(
        private val groupInterface: GroupInterface? = null,
): AccountInterface {
    var idAccount: String? = null

    fun cId(){
        if (idAccount == null){
            try {
                idAccount = UserID().create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    override fun getGroupInterface(): GroupInterface? {
        return groupInterface
    }
}