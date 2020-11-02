package com.sfinancial.admin.adminUser


import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupInterface

class AdminUserAccount(
        private val groupInterface: GroupInterface? = null,
        private val dbInterface: DBInterface? =null
) {
    fun register(){
        try {
            if (groupInterface!=null && groupInterface.verifier()){

            }
        }
    }

}