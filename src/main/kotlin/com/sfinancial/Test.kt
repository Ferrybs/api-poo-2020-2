package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sfinancial.address.Address
import com.sfinancial.category.Category
import com.sfinancial.config.mongoConfig.IndexMongoConfig
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.database.mongodb.mongoFactory.*
import com.sfinancial.login.UserLogin
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction
import com.sun.jndi.cosnaming.IiopUrl


fun main() {
    val setting = ReadMongoConfig()
    val database = StrategyMongodb(setting.getConnectionString(),setting.getDatabaseName()).getDatabase()
    val map = jacksonObjectMapper()
//    val transaction = Transaction("1231","10 - 121- 11",123.00,"Fatee")
//
//    val user = GetUserAccountMongoFactory(database).get(UserLogin("felipe","123456"))
//    val creditCard  = CreditCard(number = "1234 1234 1234 1234")
//    NewTransactionMongoFactory(database).add(creditCard,transaction)

//    val idx = IndexMongoConfig()
//    idx.setUserAccount()
//    idx.setCreditCard()
    val transaction = Transaction(
            "1231",
            "10 22 221",
            123.23,
            "Facaaaa"
    )
    val user = GetUserAccountMongoFactory(database).get(UserLogin("felipe","123456"))
    DeleteTransactionMongoFactory(database).delete(transaction)

}