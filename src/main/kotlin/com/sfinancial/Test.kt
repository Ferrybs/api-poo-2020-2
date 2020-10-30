package com.sfinancial

import com.google.gson.Gson
import com.sfinancial.config.nettyconfig.NettyConfig
import com.sfinancial.database.mongodb.MongoManagement

fun main(){
    val cString = NettyConfig().getConnectionString()
    val dbname = NettyConfig().getDatabaseName()
    val database = MongoManagement(cString,dbname)
    Thread.sleep(3000)
    val status = database.client.clusterDescription.shortDescription
    val gson = Gson()
    println(status.slice((status.length-9)..status.length))
}