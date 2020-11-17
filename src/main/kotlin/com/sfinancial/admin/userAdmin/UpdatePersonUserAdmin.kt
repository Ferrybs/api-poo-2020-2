package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.person.Person

class UpdatePersonUserAdmin(
    private val dbInterface: DBInterface
) {
    fun update(userAccount: UserAccount, person: Person){
        try {
            dbInterface.updateUserPerson(userAccount,person)
        }catch (e:  Exception){
            throw e
        }
    }
}