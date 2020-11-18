package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.AdminAccount
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.InvalidCredentialException
import org.litote.kmongo.findOne

class GetAdminAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {
    fun get(loginInterface: LoginInterface): AdminAccount {
        try {
            val coll = getCollAdmin()
            val login = coll.findOne(
                    "{'admin.username': '${loginInterface.getUsername()}'," +
                            "'admin.password': '${loginInterface.getPassword()}'}"
            )
            if (login!=null) return login
            throw InvalidCredentialException("Invalid Credential!")
        }catch (e: Exception){
            throw e
        }
    }
}