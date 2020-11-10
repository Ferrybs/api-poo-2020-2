package com.sfinancial.verifier

import com.sfinancial.group.GroupInterface
import com.sfinancial.notification.exception.FailedVerifierException

class GroupVerifier(
        private val groupInterface: GroupInterface
) {
    fun verifier(): Boolean {
        try {
            if (groupInterface.verifier()){
                return true
            }
            return false
        }catch (e: Exception){
            throw FailedVerifierException("Failed to verifier user")
        }
    }
}