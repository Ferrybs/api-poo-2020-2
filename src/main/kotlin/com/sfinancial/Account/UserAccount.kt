package com.sfinancial.Account

import com.sfinancial.admin.adminID.CreateID
import com.sfinancial.group.GroupInterface

class UserAccount(
        private val groupInterface: GroupInterface,
): AccountInterface {
    private fun cId(){

    }
    override fun getGroupInterface(): GroupInterface {
        return groupInterface
    }
}