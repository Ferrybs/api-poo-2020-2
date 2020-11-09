package com.sfinancial.feature.statusPages

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.PersonAdmin

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class ExpenseManager (
        private val personAdmin: PersonAdmin? = null
)

{
}