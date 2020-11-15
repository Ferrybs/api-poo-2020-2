package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.database.mongodb.mongoFactory.GetUserAccountMongoFactory
import com.sfinancial.database.mongodb.mongoFactory.NewTransactionMongoFactory
import com.sfinancial.login.UserLogin
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.transaction.Transaction


fun main() {
    val setting = ReadMongoConfig()
    val database = StrategyMongodb(setting.getConnectionString(),setting.getDatabaseName()).getDatabase()
    val map = jacksonObjectMapper()
    val transaction = Transaction("1231","10 - 121- 11",123.00,"Fatee")

    val user = GetUserAccountMongoFactory(database).get(UserLogin("felipe","123456"))
    val creditCard  = CreditCard(number = "1234 1234 1234 1234")
    NewTransactionMongoFactory(database).add(user,creditCard,transaction)


}