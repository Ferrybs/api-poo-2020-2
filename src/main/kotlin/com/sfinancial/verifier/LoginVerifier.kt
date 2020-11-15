package com.sfinancial.verifier

import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedVerifierException

class LoginVerifier(
        private val loginInterface: LoginInterface
) {
    fun verifier():Boolean{
        try {
            if (loginInterface.verifier()){
                return true
            }
            return false
        }catch (e: Exception){
            throw e
        }
    }
}