package com.sfinancial.group

import com.sfinancial.person.PersonInterface

class User(
        private var username: String? = null,
        private var password: String? = null,
        private var personInterface: PersonInterface? = null,
): GroupInterface {

    override fun getPersonInterface(): PersonInterface? {
        return personInterface
    }
    override fun verifier():Boolean{
        val person = personInterface
        if (person != null && person.verifier()){
            val hasNul = listOf(
                username,
                password
            ).any { it == null }
            if (!hasNul) return true
        }
        return false
    }
}