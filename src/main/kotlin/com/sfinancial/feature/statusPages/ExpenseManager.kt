package com.sfinancial.feature.statusPages

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.AdminPerson

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class ExpenseManager (
        private val adminPerson: AdminPerson? = null
)

{
}