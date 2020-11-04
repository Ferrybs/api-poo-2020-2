package sFinancial.mongodb

import com.mongodb.client.MongoDatabase
import com.sfinancial.config.nettyConfig.ReadNettyConfig
import com.sfinancial.database.mongodb.MongoConnection
import org.junit.Assert

import org.junit.Test

class TestMongo {

    private fun getCliente(): MongoConnection {
        try {
            val netty = ReadNettyConfig()
            val stringConnection = netty.getConnectionString()
            val dbname = netty.getDatabaseName()
            return MongoConnection(stringConnection,dbname)
        }catch (e: Exception){
            throw e
        }
    }
    private fun getDB(): MongoDatabase {
        try {
            val client = getCliente()
            return client.getDatabase()
        }catch (e: Exception){
            throw e
        }
    }

    fun testAll(){
        testClientConnection()
        testDBConnection()
    }

    @Test
    fun testClientConnection(){
        val client = getCliente()
        Thread.sleep(3000)
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