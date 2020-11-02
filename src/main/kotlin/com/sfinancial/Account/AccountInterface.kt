package com.sfinancial.Account

import com.sfinancial.group.GroupInterface
import com.sfinancial.person.PersonInterface

interface AccountInterface {
    fun getGroupInterface(): GroupInterface?
}