package com.sfinancial.verifier

import com.sfinancial.group.GroupInterface
import com.sfinancial.notification.exception.FailedVerifier

class VerifierUser(
        val groupInterface: GroupInterface? = null
) {
    fun verifier(): Boolean {
        try {
            if (groupInterface !=null && groupInterface.verifier()){
                return true
            }
            return false
        }catch (e: Exception){
            throw FailedVerifier("Filied to verifier user")
        }
    }
}