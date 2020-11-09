package com.sfinancial.verifier

import com.sfinancial.group.GroupInterface
import com.sfinancial.notification.exception.ExceptionFailedVerifier

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
            throw ExceptionFailedVerifier("Failed to verifier user")
        }
    }
}