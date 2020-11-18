package com.sfinancial.admin.userAdmin

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.person.Person

class UpdatePersonUserAdmin(
    private val dbInterface: DBInterface
) {
    fun update(person: Person){
        try {
            dbInterface.updateUserPerson(person)
        }catch (e:  Exception){
            throw e
        }
    }
}