package com.sfinancial.config.mongoConfig

class EnvMongoConfig: MongoConfigInterface {

    override fun getConnectionString(): String {
        return try {
                System.getenv("MONGODB_URI")
            }catch (e: Exception){
                throw e
            }
    }
    override fun getDatabaseName(): String{
        return try {
                System.getenv("dbName") ?: "apiPoo"
            }catch (e: Exception){
                throw e
            }
    }
}