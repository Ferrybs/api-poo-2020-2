package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginInterface

class UpdateAddressUserAdmin(
    private val dbInterface: DBInterface
) {
    fun update(userAccount: UserAccount, address: Address){
        try {
            dbInterface.updateAddress(userAccount, address)
        }catch (e: Exception){
            throw e
        }

    }
}