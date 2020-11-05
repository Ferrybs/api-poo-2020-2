package com.sfinancial.database

import com.sfinancial.account.UserAccount

interface DBInterface {
    fun insertNewUserAccount(userAccount: UserAccount)
}