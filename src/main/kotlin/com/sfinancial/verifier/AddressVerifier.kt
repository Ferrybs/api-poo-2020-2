package com.sfinancial.verifier

import com.sfinancial.address.AddressInterface

class AddressVerifier (
    private val addressInterface: AddressInterface
    ) {
    fun verifier(): Boolean {
        try {
            return addressInterface.verifier()
        }catch (e : Exception){
            throw e
        }
    }
}