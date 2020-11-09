package com.sfinancial.account

import com.sfinancial.group.GroupUser

interface AccountInterface {
    fun getUser(): GroupUser?
}