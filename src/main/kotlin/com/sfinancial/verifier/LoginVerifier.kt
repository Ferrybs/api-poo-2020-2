package com.sfinancial.verifier

import com.sfinancial.login.LoginInterface

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