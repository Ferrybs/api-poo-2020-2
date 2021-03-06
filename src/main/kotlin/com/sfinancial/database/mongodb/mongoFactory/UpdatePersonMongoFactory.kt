package com.sfinancial.database.mongodb.mongoFactory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mongodb.client.MongoDatabase
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.notification.exception.FailedUpdateException
import com.sfinancial.person.Person
import com.sfinancial.transaction.Transaction
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.updateOne
import org.litote.kmongo.MongoOperator.*

class UpdatePersonMongoFactory(
        database: MongoDatabase
): MongoFactory(database){
    private val map = jacksonObjectMapper()
    fun update(person: Person){
        try {
            val coll = getCollUserAccount()
            val string = map.writeValueAsString(person)
            val status= coll.updateOne(
                    "{'user.person.document':'${person.getDocument()}'}",
                    "{${set}:{'user.person':$string}}"
            )
            if(status.modifiedCount.toInt()==0) {
                throw FailedUpdateException("Failed to update person! Matches: ${status.matchedCount} ")
            }
        }catch (e:Exception){
            throw e
        }
    }
}