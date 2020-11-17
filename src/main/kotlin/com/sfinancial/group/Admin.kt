package com.sfinancial.group

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.AdminPerson
import io.ktor.auth.*

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class Admin (
        username:String,
        password:String,
        private val adminPerson: AdminPerson? = null
):Group(username,password),GroupInterface{

    override fun verifier(): Boolean {
        if(adminPerson!=null && adminPerson.verifier()){
            return verifierGroup()
        }
        return false
    }
}