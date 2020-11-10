package com.sfinancial.admin.idAdmin

import com.sfinancial.config.hashidConfig.ReadHashidConfig
import com.sfinancial.notification.exception.FailedEncryptHashIdException
import org.hashids.Hashids

class UserIdAdmin(
): IdAdminInterface{

    private fun getEnvHashidSecret():String{
        try {
            return ReadHashidConfig().getSecretHashid()
        }catch (e: Exception){
            throw e
        }
    }
    override fun create(): String {
        val rand1 = (1000..99999).shuffled().first()
        val rand2 = (1000..99999).shuffled().first()
        var final = (rand1 * rand2).toLong()
        if (final < 0) final *= (-1)
        try {
            val hashids = Hashids(getEnvHashidSecret(), 6, "1234567890abcdef")
            return hashids.encode(final)
        }catch (e: Exception){
            throw FailedEncryptHashIdException("Failed to encrypt hashid")
        }
    }
}