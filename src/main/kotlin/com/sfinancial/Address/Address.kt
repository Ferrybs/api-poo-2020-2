package com.sfinancial.Address

class Address(
        var street: String? = null,
        var number: String?= null,
        var complement: String? = null,
        var zipCode: String? = null,
        var city: String? = null,
        var state: String? = null,
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