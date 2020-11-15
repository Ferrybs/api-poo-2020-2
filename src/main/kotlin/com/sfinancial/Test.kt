package com.sfinancial

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.category.Category
import com.sfinancial.config.mongoConfig.IndexMongoConfig
import com.sfinancial.config.mongoConfig.ReadMongoConfig
import com.sfinancial.config.nettyConfig.EnvNettyConfig
import com.sfinancial.config.nettyConfig.NettyConfigInterface
import com.sfinancial.database.mongodb.ManagementMongodb
import com.sfinancial.database.mongodb.mongoFactory.GetUserAccountMongoFactory
import com.sfinancial.database.mongodb.mongoFactory.NewCreditCardMongoFactory
import com.sfinancial.group.User
import com.sfinancial.login.UserLogin
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.Person
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.litote.kmongo.util.KMongoUtil
import java.util.*


fun main() {
    val nettyConfig = EnvNettyConfig()
    embeddedServer(Netty,port = nettyConfig.getPort()){
        routing {
            get(""){
                call.respond(HttpStatusCode.Accepted,"FUNCIONA")
            }
        }
    }
}