package com.sfinancial.Account

import com.sfinancial.admin.adminID.AdminUserHashid
import com.sfinancial.group.GroupInterface

class UserAccount(
        private val groupInterface: GroupInterface? = null,
): AccountInterface {
    var idAccount: String? = null

    fun cId(){
        if (idAccount == null){
            try {
                idAccount = AdminUserHashid().create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    override fun getGroupInterface(): GroupInterface? {
        return groupInterface
    }
}