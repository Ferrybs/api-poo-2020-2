package com.sfinancial.group

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.person.AdminPerson
import io.ktor.auth.*

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

class Financial (
        private val username:String? = null,
        private val password:String? = null,
        private val adminPerson: AdminPerson? = null
):Principal{
    fun verifier(): Boolean {
        val hasNul = listOf(
                username,
                password,
                adminPerson
        ).any { it == null }
        return !hasNul

    }
}