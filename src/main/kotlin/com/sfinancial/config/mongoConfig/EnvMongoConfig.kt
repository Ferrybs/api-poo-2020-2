package com.sfinancial.config.mongoConfig

class EnvMongoConfig: MongoConfigInterface {

    override fun getConnectionString(): String {
        return try {
                System.getenv("cString")
            }catch (e: Exception){
                throw e
            }
    }
    override fun getDatabaseName(): String{
        return try {
                System.getenv("dbName")
            }catch (e: Exception){
                throw e
            }
    }
}