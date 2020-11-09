package sFinancial.mongodb

import com.mongodb.client.MongoDatabase
import com.sfinancial.config.mongoConfig.MongoConfigEnv
import com.sfinancial.database.mongodb.MongoDbConnection
import org.junit.Assert

import org.junit.Test

class TestMongo {

    private fun getClient(): MongoDbConnection {
        try {
            val config = MongoConfigEnv()
            val stringConnection = config.getConnectionString()
            val dbname = config.getDatabaseName()
            return MongoDbConnection(stringConnection,dbname)
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
        println(client.getClientString())
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