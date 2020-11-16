package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.notification.exception.FailedUpdateException
import org.litote.kmongo.updateOne
import org.litote.kmongo.MongoOperator.*

class DeleteAddressMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {
    private val map = jacksonObjectMapper()
    fun delete(userAccount: UserAccount,address: Address){
        try {
            val coll = getCollUserAccount()
            val string = map.writeValueAsString(address)
            val status = coll.updateOne(
                    "{'idAccount':'${userAccount.getIdAccount()}'}",
                    "{${unset}:{'user.person.address':1}}"
            )
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to update! Matches: ${status.matchedCount} ")
            }
        }catch (e: Exception){
            throw e
        }

    }
}