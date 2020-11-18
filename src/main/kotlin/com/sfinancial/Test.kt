package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.sfinancial.account.UserAccount
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.call.CallUserAccountCreditCard
import com.sfinancial.category.Category
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.group.Financial
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.AdminPerson
import com.sfinancial.person.Person


fun main() {
    val setting = ReadMongoConfig()
    val database = StrategyMongodb(setting.getConnectionString(),setting.getDatabaseName()).getDatabase()
    val map = jacksonObjectMapper()
    val gson = Gson()
    val classifier = Financial(
            "admin",
            "admin",
            AdminPerson(
                    "1234"
            )
    )

    //adminAccount.cId(HashIdAdmin(ReadHashidConfig()))
    //val coll = database.getCollection<AdminAccount>()
    //coll.insertOne(adminAccount)
    println(gson.toJson(CallUserAccountCreditCard(
            UserAccount(),
            CreditCard("Felipe","9999","12-32","21","212")
    )))
}