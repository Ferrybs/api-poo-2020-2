package com.sfinancial.database

import com.sfinancial.account.UserAccount
import com.sfinancial.login.LoginInterface

interface DBInterface {
    fun insertNewAccountUser(userAccount: UserAccount)
    fun getAccountUser(loginInterface: LoginInterface): UserAccount
}