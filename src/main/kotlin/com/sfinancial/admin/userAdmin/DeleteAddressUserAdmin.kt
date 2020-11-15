package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface

class DeleteAddressUserAdmin(
    private val dbInterface: DBInterface
) {
    fun delete(userAccount: UserAccount, address: Address){
        try {
        dbInterface.deleteAddress(address)
        }catch (e:Exception){
            throw e
        }
    }
}