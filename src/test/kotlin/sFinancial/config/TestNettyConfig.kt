package sFinancial.config

import com.sfinancial.config.nettyconfig.NettyConfig
import org.junit.Assert
import org.junit.Test

class TestNettyConfig {
    private val nettyConfig = NettyConfig()

    fun testAll(){
        testConnectionString()
        testDBname()
        testSecretJwt()
        testIssuer()
    }

    @Test
    fun testConnectionString(){
        try {
            val connectionString = nettyConfig.getConnectionString()
            Assert.assertEquals(String,connectionString)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testDBname(){
        try {
            val dbName = nettyConfig.getConnectionString()
            Assert.assertEquals(String,dbName)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretJwt(){
        try {
            val secret = nettyConfig.getSecretJwt()
            Assert.assertEquals(String,secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testIssuer(){
        try {
            val secret = nettyConfig.getIssuer()
            Assert.assertEquals(String,secret)
        }catch (e: Exception){
            throw e
        }
    }
}