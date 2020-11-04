package com.sfinancial.database

import com.sfinancial.Account.AccountInterface
import com.sfinancial.Account.UserAccount

interface DBInterface {
    fun insertNewUserAccount(userAccount: UserAccount)
}