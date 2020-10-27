package com.sfinancial.Account

import com.sfinancial.admin.adminID.AdminIDInterface
import com.sfinancial.group.GroupInterface

class UserAccount(
        private val groupInterface: GroupInterface,
): AccountInterface {
    var idAccount: String? = null

    private fun cId(adminIDInterface: AdminIDInterface){
        if (idAccount == null){
            try {
                idAccount = adminIDInterface.create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    override fun getGroupInterface(): GroupInterface {
        return groupInterface
    }
}