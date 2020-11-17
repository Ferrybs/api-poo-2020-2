package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.group.Classifier
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.InvalidCredentialException
import org.litote.kmongo.findOne

class GetClassifierAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {
    fun get(loginInterface: LoginInterface): Classifier {
        try {
            val coll = getCollClassifier()
            val login = coll.findOne(
                    "{'user.username': '${loginInterface.getUsername()}'," +
                            "'user.password': '${loginInterface.getPassword()}'}")
            if (login!=null) return login
            throw InvalidCredentialException("Invalid Credential!")
        }catch (e: Exception){
            throw e
        }
    }
}