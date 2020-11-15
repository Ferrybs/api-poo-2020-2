package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.notification.exception.FailedFindException
import org.litote.kmongo.findOne

class GetUserPaymentMongoFactory(
    database: MongoDatabase
) : MongoFactory(database) {
    fun get(number: String): UserAccount {
        try {
            val coll = getCollUserAccount()
            val userAccount = coll.findOne("{'payment':${number}}")
            if (userAccount != null){
                return userAccount
            }else{
                throw FailedFindException("Failed to find Account!")
            }
        }catch (e: Exception){
            throw e
        }
    }
}