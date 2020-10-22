package com.sfinancial.database

import com.sfinancial.Account.AccountInterface

interface DBInterface {
    fun registerAccount(accountInterface: AccountInterface)
}