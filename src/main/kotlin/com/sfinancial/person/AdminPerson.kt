package com.sfinancial.person

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.notification.exception.InvalidFieldsException

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class AdminPerson (
        private  val idEmployee: String? = null
):PersonInterface{
    override fun verifier(): Boolean {
        return idEmployee != null
    }

    override fun getDocument(): String {
        try {
            if (idEmployee!=null){
                return idEmployee
            }else{
                throw InvalidFieldsException("idEmployee")
            }
        }catch (e: Exception){
            throw e
        }
    }
}