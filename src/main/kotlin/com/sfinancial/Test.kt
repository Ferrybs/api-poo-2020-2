package com.sfinancial

import ClassifierAccount
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.sfinancial.address.Address
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.category.Category
import com.sfinancial.config.mongoConfig.IndexMongoConfig
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.database.mongodb.mongoFactory.*
import com.sfinancial.group.Classifier
import com.sfinancial.group.User
import com.sfinancial.login.UserLogin
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.AdminPerson
import com.sfinancial.person.Person
import com.sfinancial.transaction.Transaction


fun main() {
    //val setting = ReadMongoConfig()
    //val database = StrategyMongodb(setting.getConnectionString(),setting.getDatabaseName()).getDatabase()
    val map = jacksonObjectMapper()
    val gson = Gson()
    val account = ClassifierAccount(
            Classifier(
                    "classifier",
                    "123456",
                    AdminPerson("123 323 332 32")
            )
    )
    println(gson.toJson(account))
    IndexMongoConfig().setCreditCard()
}