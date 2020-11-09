package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import javax.jws.soap.SOAPBinding

class LoginUserAccount(
        database: MongoDatabase,
        private val loginInterface: LoginInterface
) : MongoFactory(database) {

    fun getUserAccount(): UserAccount?{
        val coll = getCollUserAccount()
        val login = coll.findOne(
                "{'user.username': '${loginInterface.getUsername()}'}," +
                        "{'user.password': '${loginInterface.getPassword()}'}")
        return login
    }
}