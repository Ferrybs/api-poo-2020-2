package com.sfinancial.group

import com.sfinancial.person.AdminPerson
import com.sfinancial.person.Person

class Classifier(
        username: String,
        password: String,
        private val person: AdminPerson? = null
):Group(username,password),GroupInterface{

    override fun verifier(): Boolean {
        if(person!=null && person.verifier()){
            return verifierGroup()
        }
        return false
    }
}