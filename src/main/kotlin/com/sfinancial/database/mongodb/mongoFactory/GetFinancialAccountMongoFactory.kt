package com.sfinancial.database.mongodb.mongoFactory

import ClassifierAccount
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.FinancialAccount
import com.sfinancial.group.Classifier
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.InvalidCredentialException
import org.litote.kmongo.findOne

class GetFinancialAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {
    fun get(loginInterface: LoginInterface): FinancialAccount {
        try {
            val coll = getCollFinancial()
            val login = coll.findOne(
                    "{'financial.username': '${loginInterface.getUsername()}'," +
                            "'financial.password': '${loginInterface.getPassword()}'}")
            if (login!=null) return login
            throw InvalidCredentialException("Invalid Credential!")
        }catch (e: Exception){
            throw e
        }
    }
}