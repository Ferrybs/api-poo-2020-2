package com.sfinancial.address

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class Address(
        private val street: String? = null,
        private val number: String?= null,
        private val complement: String? = null,
        private val zipCode: String? = null,
        private val city: String? = null,
        private val state: String? = null,
){
        fun verifier(): Boolean{
                val hasNull = listOf(
                        street,
                        number,
                        complement,
                        zipCode,
                        city,
                        state
                ).any{it == null}

                return !hasNull
        }
}