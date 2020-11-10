package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.InvalidCredentialException
import org.litote.kmongo.and
import org.litote.kmongo.findOne
import org.litote.kmongo.util.KMongoUtil

class GetUserAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun get(loginInterface: LoginInterface): UserAccount{
        try {
            val coll = getCollUserAccount()
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