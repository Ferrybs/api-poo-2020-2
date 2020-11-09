package com.sfinancial.verifier

import com.sfinancial.group.GroupInterface
import com.sfinancial.notification.exception.FailedVerifier

class VerifierGroup(
        private val groupInterface: GroupInterface
) {
    fun verifier(): Boolean {
        try {
            if (groupInterface.verifier()){
                return true
            }
            return false
        }catch (e: Exception){
            throw FailedVerifier("Failed to verifier user")
        }
    }
}