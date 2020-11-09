package com.sfinancial.database

import com.sfinancial.account.AccountUser

interface DBInterface {
    fun insertNewUserAccount(userAccount: AccountUser)
}