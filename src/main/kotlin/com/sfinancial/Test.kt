package com.sfinancial

import com.google.gson.Gson
import com.sfinancial.address.Address
import com.sfinancial.config.mongoConfig.MongoIndexConfig
import com.sfinancial.group.User
import com.sfinancial.person.Person


fun main(){
//    val endereco = Address(
//            "test",
//            "test",
//            "teste",
//            "test",
//            "test",
//            "test"
//    )
//    val pessoa = Person(
//           null,
//            "test",
//            "test",
//            "test",
//            endereco
//    )
//
//    val user = User("test","test",pessoa)
//
//    val gson = Gson()
//    println(gson.toJson(user))

    MongoIndexConfig().setUserAccount()

}