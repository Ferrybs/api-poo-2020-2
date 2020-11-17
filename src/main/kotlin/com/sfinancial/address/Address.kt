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
):AddressInterface{
      override fun verifier(): Boolean{
                val hasNull = listOf(
                        street,
                        number,
                        zipCode,
                        city,
                        state
                ).any{it == null}

                return !hasNull
        }
}