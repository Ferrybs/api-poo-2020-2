package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sfinancial.address.Address
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.category.Category
import com.sfinancial.config.mongoConfig.IndexMongoConfig
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.database.mongodb.mongoFactory.*
import com.sfinancial.group.User
import com.sfinancial.login.UserLogin
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.Person
import com.sfinancial.transaction.Transaction


fun main() {
    //val setting = ReadMongoConfig()
    //val database = StrategyMongodb(setting.getConnectionString(),setting.getDatabaseName()).getDatabase()
    val map = jacksonObjectMapper()
    val address = Address(
            "Av a",
            "1232",
            "122",
            "121 322",
            "Bras",
            "SP"
    )
    println(map.writeValueAsString(address))
    IndexMongoConfig().setCreditCard()
}