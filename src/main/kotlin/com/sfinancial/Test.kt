package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.group.User
import com.sfinancial.person.Person
import org.litote.kmongo.util.KMongoUtil


fun main() {
//    val gson = Gson()
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
//    val map = jacksonObjectMapper()
//
//    println(map.writeValueAsString(user))


    val bson = KMongoUtil.toBson("{'username': 'felipe','password':'123345'}")
    println(bson)

}