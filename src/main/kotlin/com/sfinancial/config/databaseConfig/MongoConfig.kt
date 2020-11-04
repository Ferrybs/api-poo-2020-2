package com.sfinancial.config.databaseConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class MongoConfig: DatabaseConfigInterface {

    override fun getConnectionString(): String {
        try {
            return File("connectionString.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: connectionString nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
    override fun getDatabaseName(): String{
        try {
            return File("databaseName.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            throw FileNotFound("Arquivo: databaseName nao encontrado!")
        }catch (e: Exception){
            throw e
        }
    }
}