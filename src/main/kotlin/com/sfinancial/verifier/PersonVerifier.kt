package com.sfinancial.verifier


import com.sfinancial.person.PersonInterface

class PersonVerifier(
    val personInterface: PersonInterface
) {
    fun verifier():Boolean{
        try {
            if (personInterface.verifier()){
                return true
            }
            return false
        }catch (e: Exception){
            throw e
        }
    }
}
