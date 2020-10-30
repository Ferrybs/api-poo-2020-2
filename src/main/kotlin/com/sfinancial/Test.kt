package com.sfinancial

import com.sfinancial.database.mongodb.MongoManagement
import com.sfinancial.server.netty.NettyConfig
import org.litote.kmongo.json
import org.litote.kmongo.util.idValue

fun main(){
    val cString = NettyConfig().getConnectionString()
    val dbname = NettyConfig().getDatabaseName()
    val database = MongoManagement(cString,dbname)
    println(database.connect())
}