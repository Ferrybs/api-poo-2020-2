package com.sfinancial

import com.sfinancial.auth.AuthJwt
import com.sfinancial.database.mongodb.MongoManagement
import com.sfinancial.server.netty.NettyServer
import java.io.File


fun main(){
    val connectionString = File("ConnectionString.txt").readLines()[0]
    val databaseName = "apiPoo2020"
    val secret = "M3U-D3US-vazei-a-senha-do-banco-de-dados-123456"
    val authJwt = AuthJwt(secret)
    val database =  MongoManagement(connectionString,databaseName)
    val server = NettyServer(authJwt,database)
    val sfinancial= Sfinancial(server)
    sfinancial.startServer()
}