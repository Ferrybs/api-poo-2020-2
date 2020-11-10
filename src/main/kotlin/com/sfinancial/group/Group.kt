package com.sfinancial.group

open class Group(
    private val username: String? = null,
    private val password: String?=null
) {
    fun getUsername(): String? {
        return username
    }

    fun getPassword(): String? {
        return username
    }

    fun verifierGroup(): Boolean {
        val hasNul = listOf(
            username,
            password
        ).any { it == null }
        if (!hasNul) return true

        return false
    }
}