package com.sfinancial.person

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.address.Address


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
open class Person(
        private val name: String? = null,
        private val lastName: String? = null,
        private val birth: String? = null,
        private val document: String? = null,
        private val address: Address? = null
) : PersonInterface {

    override fun verifier(): Boolean {
        val hasNull = listOf(
                name,
                lastName,
                birth,
                document
        ).any { it == null }

        return !hasNull
    }

}