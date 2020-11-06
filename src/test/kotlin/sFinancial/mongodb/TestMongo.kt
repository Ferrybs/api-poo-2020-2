package sFinancial.mongodb

import com.mongodb.client.MongoDatabase
import com.sfinancial.config.databaseConfig.ReadMongoConfig
import com.sfinancial.database.mongodb.MongoConnection
import org.junit.Assert

import org.junit.Test

class TestMongo {

    private fun getClient(): MongoConnection {
        try {
            val config = ReadMongoConfig()
            val stringConnection = config.getConnectionString()
            val dbname = config.getDatabaseName()
            return MongoConnection(stringConnection,dbname)
        }catch (e: Exception){
            throw e
        }
    }
    private fun getDB(): MongoDatabase {
        try {
            val client = getClient()
            return client.getDatabase()
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testClientConnection(){
        val client = getClient()
        Thread.sleep(3000)
        println(client.getConnectionString())
        Assert.assertEquals(true,client.getConnectionStatus())
    }
    @Test
    fun testDBConnection(){
        try {
            val database =getDB()
            Assert.assertEquals("apiPoo2020",database.name)
        }catch (e: Exception){
            throw e
        }
    }
}