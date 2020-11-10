package com.sfinancial.group

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.AdminPerson

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class ExpenseManager (
        username:String,
        password:String,
        private val adminPerson: AdminPerson? = null
): Group()
{
}