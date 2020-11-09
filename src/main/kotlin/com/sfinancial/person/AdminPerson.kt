package com.sfinancial.person

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class AdminPerson (
        private  val idemployee: String? = null

)

{
}