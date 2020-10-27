package com.sfinancial.Address

class Address(
        var street: String,
        var number: String,
        var complement: String? = null,
        var zipCode: String,
        var city: String,
        var state: String,
) {
}