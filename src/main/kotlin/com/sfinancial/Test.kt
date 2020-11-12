package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.ManagementMongodb
import com.sfinancial.database.mongodb.mongoFactory.GetUserAccountMongoFactory
import com.sfinancial.database.mongodb.mongoFactory.NewCreditCardMongoFactory
import com.sfinancial.group.User
import com.sfinancial.login.UserLogin
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.Person
import org.litote.kmongo.util.KMongoUtil


fun main() {
    val gson = Gson()
//    val endereco = Address(
//            "Av a",
//            "123",
//            "teste",
//            "123452 323",
//            "Brasilia",
//            "DF"
//    )
//    val pessoa = Person(
//            "Felipe",
//            "Araujo",
//            "10-10-1003",
//            "123 233 445 21",
//            endereco
//    )
//
//    val user = User(
//            "Felipe",
//            "123456",
//            pessoa
//            )
//
//      val userAccount = UserAccount(user)
    val map = jacksonObjectMapper()
//
//    println(map.writeValueAsString(user))
    val mongo = ManagementMongodb(ReadMongoConfig().getConnectionString(), ReadMongoConfig().getDatabaseName()).getDatabase()
    val creditCard = CreditCard("teste", "teste", "teste", "teste", "teste")
    val userAccount = GetUserAccountMongoFactory(mongo).get(UserLogin("felipe", "123456"))
    NewCreditCardMongoFactory(mongo).create(userAccount,creditCard)
    val string = map.writeValueAsString(creditCard)
    println(string)


}