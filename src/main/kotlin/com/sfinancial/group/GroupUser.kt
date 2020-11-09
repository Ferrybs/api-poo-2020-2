package com.sfinancial.group


import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.Person

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class GroupUser(
        private val username: String? = null,
        private val password: String? = null,
        private val person: Person? = null,
): GroupInterface {

    override fun getPerson(): Person? {
        return person
    }
    override fun verifier():Boolean{
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