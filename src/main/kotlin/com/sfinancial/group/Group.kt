package com.sfinancial.group

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
open class Group(
        private val username: String? = null,
        private val password: String? = null
) {

    fun getUsername(): String? {
        return username
    }

    fun getPassword(): String? {
        return password
    }

    fun verifierGroup(): Boolean {
        val hasNul = listOf(
                username,
                password
        ).any { it == null }
        return !hasNul

    }

}