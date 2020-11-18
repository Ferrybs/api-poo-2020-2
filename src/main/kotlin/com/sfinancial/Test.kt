package com.sfinancial

import ClassifierAccount
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.sfinancial.account.AdminAccount
import com.sfinancial.address.Address
import com.sfinancial.admin.idAdmin.HashIdAdmin
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.category.Category
import com.sfinancial.config.hashidConfig.ReadHashidConfig
import com.sfinancial.config.mongoConfig.IndexMongoConfig
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.database.mongodb.mongoFactory.*
import com.sfinancial.group.Admin
import com.sfinancial.group.Classifier
import com.sfinancial.group.User
import com.sfinancial.login.UserLogin
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.AdminPerson
import com.sfinancial.person.Person
import com.sfinancial.transaction.Transaction
import org.litote.kmongo.getCollection


fun main() {
    val setting = ReadMongoConfig()
    val database = StrategyMongodb(setting.getConnectionString(),setting.getDatabaseName()).getDatabase()
    val map = jacksonObjectMapper()
    val gson = Gson()
    val classifier = Classifier(
            "admin",
            "admin",
            AdminPerson(
                    "1234"
            )
    )

    //adminAccount.cId(HashIdAdmin(ReadHashidConfig()))
    //val coll = database.getCollection<AdminAccount>()
    //coll.insertOne(adminAccount)
    println(gson.toJson(classifier))
}