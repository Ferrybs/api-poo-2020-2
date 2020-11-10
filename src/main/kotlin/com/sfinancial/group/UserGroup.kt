package com.sfinancial.group


import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.Person

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
open class UserGroup(
    username: String,
    password: String,
    private val person: Person? = null
) : Group(username, password), GroupInterface {

    override fun verifier(): Boolean {
        if (person!=null && person.verifier() && verifierGroup()){
            return true
        }
        return false
}
}