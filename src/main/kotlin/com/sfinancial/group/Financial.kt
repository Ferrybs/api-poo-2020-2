package com.sfinancial.group

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.AdminPerson
import io.ktor.auth.*

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class Financial (
        username:String,
        password:String,
        private val person: AdminPerson? = null
):Group(username,password),GroupInterface{

    override fun verifier(): Boolean {
        if(person!=null && person.verifier()){
            return verifierGroup()
        }
        return false
    }
}