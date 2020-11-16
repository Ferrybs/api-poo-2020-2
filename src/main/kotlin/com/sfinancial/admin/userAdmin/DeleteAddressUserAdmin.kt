package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface

class DeleteAddressUserAdmin(
    private val dbInterface: DBInterface
) {
    fun delete(userAccount: UserAccount){
        try {
        dbInterface.deleteAddress(userAccount)
        }catch (e:Exception){
            throw e
        }
    }
}