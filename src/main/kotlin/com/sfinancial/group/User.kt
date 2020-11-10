package com.sfinancial.group


import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import com.sfinancial.person.Person

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class User(
        username: String,
        password: String,
        private val person: Person? = null
):Group(username,password),GroupInterface{

    override fun verifier(): Boolean {
        if(person!=null && person.verifier()){
            return verifierGroup()
        }
        return false
    }
}