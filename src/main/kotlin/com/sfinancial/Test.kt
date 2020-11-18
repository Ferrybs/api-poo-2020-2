package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.StrategyMongodb
import com.sfinancial.group.Financial
import com.sfinancial.person.AdminPerson


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
    println(gson.toJson(classifier))
}