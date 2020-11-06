package com.sfinancial.config.databaseConfig

import com.sfinancial.notification.exception.FileNotFound
import java.io.File
import java.io.FileNotFoundException

class ReadMongoConfig: DatabaseConfigInterface {

    override fun getConnectionString(): String {
        return try {
            File("connectionString.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            try {
                System.getenv("connectionString")
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }
    override fun getDatabaseName(): String{
        return try {
            File("databaseName.txt").readLines()[0]
        }catch (e: FileNotFoundException){
            try {
                System.getenv("databaseName")
            }catch (e: Exception){
                throw e
            }
        }catch (e: Exception){
            throw e
        }
    }
}