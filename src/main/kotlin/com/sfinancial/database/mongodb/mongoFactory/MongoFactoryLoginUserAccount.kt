package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.AccountUser
import com.sfinancial.login.LoginInterface
import org.litote.kmongo.findOne
import javax.jws.soap.SOAPBinding

class MongoFactoryLoginUserAccount(
        database: MongoDatabase,
        private val loginInterface: LoginInterface
) : MongoFactory(database) {

    fun getUserAccount(): AccountUser?{
        val coll = getCollUserAccount()
        val login = coll.findOne(
                "{'user.username': '${loginInterface.getUsername()}'}," +
                        "{'user.password': '${loginInterface.getPassword()}'}")
        return login
    }
}