package com.sfinancial.category

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Category(
        private val name: String? = null,
        private val priority: String? = null,
        private val description: String? = null
) {
}