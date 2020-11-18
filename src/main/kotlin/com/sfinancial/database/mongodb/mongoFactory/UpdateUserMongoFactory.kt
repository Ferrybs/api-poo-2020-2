package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.group.User
import com.sfinancial.notification.exception.FailedUpdateException
import org.litote.kmongo.MongoOperator.*
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne

class UpdateUserMongoFactory(
        database: MongoDatabase
) :MongoFactory(database) {
    private val map = jacksonObjectMapper()
    fun update(user: User){
        try{
            val coll = getCollUserAccount()
            val status = coll.updateOne(
                    "{'user.username': '${user.getUsername()}'}",
                    "{${set}:{'user.password':'${user.getPassword()}'}}"
            )
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to update user! Matches: ${status.matchedCount} ")
            }
        }catch (e : Exception){
            throw e
        }
    }
}