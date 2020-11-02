package com.sfinancial.verifier

import com.sfinancial.group.GroupInterface
import com.sfinancial.notification.exception.FiliedVerifier

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
            throw FiliedVerifier("Filied to verifier user")
        }
    }
}