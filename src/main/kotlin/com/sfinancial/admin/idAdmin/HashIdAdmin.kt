package com.sfinancial.admin.idAdmin

import com.sfinancial.config.hashidConfig.HashIdConfigInterface
import com.sfinancial.notification.exception.FailedEncryptHashIdException
import org.hashids.Hashids

class HashIdAdmin(
        private val hashIdConfigInterface: HashIdConfigInterface
): IdAdminInterface{

    override fun create(size: Int): String {
        try{
        val rand1 = (1000..99999).shuffled().first()
        val rand2 = (1000..99999).shuffled().first()
        var final = (rand1 * rand2).toLong()
        if (final < 0) final *= (-1)
            val hashids = Hashids(
                    hashIdConfigInterface.getSecretHashId(),
                    size,
                    "1234567890abcdef"
            )
            return hashids.encode(final)
        }catch (e: Exception){
            throw FailedEncryptHashIdException("Failed to encrypt hashid")
        }
    }
}