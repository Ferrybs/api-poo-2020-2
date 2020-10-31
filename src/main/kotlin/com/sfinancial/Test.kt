package com.sfinancial


import com.sfinancial.config.nettyconfig.NettyConfig
import com.sfinancial.database.mongodb.MongoManagement

fun main(){
    val cString = NettyConfig().getConnectionString()
    val dbname = NettyConfig().getDatabaseName()

    val database = MongoManagement(cString,dbname).connect()
    Thread.sleep(3000)
    println(database.name)

}