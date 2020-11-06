package com.sfinancial.admin

import com.sfinancial.account.AccountInterface

interface AdminInterface {
    fun registerUser(accountInterface: AccountInterface)
}