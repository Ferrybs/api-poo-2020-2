package com.sfinancial.category

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Category(
        private val name: String? = null,
        private val priority: Int? = null,
        private val description: String? = null
): CategoryInterface {
    override fun verifier(): Boolean {
        return !listOf(
                name,
                priority,
                description
        ).any{it == null}
    }
}