package com.sfinancial.admin.userAdmin

import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface

class UpdateAddressUserAdmin(
    private val dbInterface: DBInterface
) {
    fun update(loginInterface: LoginInterface, address: Address){
        try {

        }catch (e: Exception){
            throw e
        }

    }
}