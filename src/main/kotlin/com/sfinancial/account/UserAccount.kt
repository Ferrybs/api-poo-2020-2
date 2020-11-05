package com.sfinancial.account

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.adminID.AdminUserHashid
import com.sfinancial.config.ConfigInterface
import com.sfinancial.group.User

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class UserAccount(
        private val user: User? = null,
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
    override fun getUser(): User? {
        return user
    }
}