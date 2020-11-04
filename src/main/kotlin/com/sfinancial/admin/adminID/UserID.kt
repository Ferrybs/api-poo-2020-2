package com.sfinancial.admin.adminID

import com.sfinancial.config.hasidconfig.HashIdInterface
import com.sfinancial.notification.exception.FailedEncryptHashId
import com.sfinancial.notification.exception.FileNotFound
import org.hashids.Hashids
import java.io.FileNotFoundException

class UserID(
    private val hashIdInterface: HashIdInterface
): AdminIDInterface{

    private fun getHashSecret():String{
        try {
            return hashIdInterface.getString()
        }catch (e: FileNotFoundException){
            throw FileNotFound("File SecretHashId not found!")
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
            val hashids = Hashids(getHashSecret(), 6, "1234567890abcdef")
            return hashids.encode(final)
        }catch (e: Exception){
            throw FailedEncryptHashId("Failed to encrypt hashid")
        }catch (e: Exception){
            throw e
        }
    }
}