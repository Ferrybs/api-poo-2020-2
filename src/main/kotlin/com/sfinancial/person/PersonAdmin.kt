package com.sfinancial.person

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class PersonAdmin (
        private  val idEmployee: String? = null

)

{
}