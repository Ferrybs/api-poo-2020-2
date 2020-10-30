package sFinancial.mongodb

import com.sfinancial.config.nettyconfig.NettyConfig
import com.sfinancial.database.mongodb.MongoConnection
import org.junit.Assert

import org.junit.Test

class TestMongo {

    @Test
    fun testConnection(){
        val netty = NettyConfig()
        val stringConnection = netty.getConnectionString()
        val dbname = netty.getDatabaseName()
        val database = MongoConnection(stringConnection,dbname).connect()
        Assert.assertEquals("apiPoo2020",database.con)
    }
}