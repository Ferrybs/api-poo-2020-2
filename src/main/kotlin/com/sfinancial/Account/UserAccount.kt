package com.sfinancial.Account

import com.sfinancial.admin.adminID.AdminUserHashid
import com.sfinancial.config.ConfigInterface
import com.sfinancial.config.jwtConfig.JwtConfigInterface
import com.sfinancial.group.GroupInterface

class UserAccount(
        private val groupInterface: GroupInterface? = null,
): AccountInterface {
    var idAccount: String? = null

    fun cId(configInterface: ConfigInterface){
        if (idAccount == null){
            try {
                idAccount = AdminUserHashid(configInterface).create()
            }catch (e: Exception){
                throw e
            }
        }
    }
    override fun getGroupInterface(): GroupInterface? {
        return groupInterface
    }
}