package com.sfinancial.category

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.notification.exception.InvalidFieldsException

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Category(
        private val name: String? = null,
        private val priority: Int? = null,
        private val description: String? = null
) : CategoryInterface {
    override fun verifier(): Boolean {
        return !listOf(
                name,
                priority,
                description
        ).any { it == null }
    }
    override fun getPriority(): Int {
        try {
            if (priority != null) {
                return priority
            }
            throw InvalidFieldsException("Category does not have priority!")
        }catch (e: Exception){
            throw e
        }
    }

    override fun getName(): String {
        try {
            if (name != null) {
                return name
            }
            throw InvalidFieldsException("Category does not have name!")
        }catch (e: Exception){
            throw e
        }
    }
}