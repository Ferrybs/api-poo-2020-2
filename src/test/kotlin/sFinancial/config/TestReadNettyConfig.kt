package sFinancial.config

import com.sfinancial.config.readNettyConfig.ReadReadNettyConfig
import org.junit.Assert
import org.junit.Test

class TestReadNettyConfig {
    private val nettyConfig = ReadReadNettyConfig()

    @Test
    fun testAll(){
        testConnectionString()
        testDBname()
        testSecretJwt()
        testSecretHasid()
        testIssuer()
        testHost()
        testPort()
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
    fun testSecretHasid(){
        try {
            val secret = nettyConfig.getSecretHashid()
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

    @Test
    fun testHost(){
        try {
            val secret = nettyConfig.getHost()
            Assert.assertEquals(String,secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testPort(){
        try {
            val secret = nettyConfig.getPort()
            Assert.assertEquals(String,secret)
        }catch (e: Exception){
            throw e
        }
    }
}