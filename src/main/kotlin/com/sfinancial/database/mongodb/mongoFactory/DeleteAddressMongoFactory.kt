package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.notification.exception.FailedUpdateException
import org.litote.kmongo.updateOne
import org.litote.kmongo.MongoOperator.*

class DeleteAddressMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {
    fun delete(userAccount: UserAccount){
        try {
            val coll = getCollUserAccount()
            val status = coll.updateOne(
                    "{'idAccount':'${userAccount.getIdAccount()}'}",
                    "{${unset}:{'user.person.address':1}}"
            )
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to delete address! Matches: ${status.matchedCount} ")
            }
        }catch (e: Exception){
            throw e
        }

    }
}