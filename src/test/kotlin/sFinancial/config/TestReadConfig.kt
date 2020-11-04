package sFinancial.config

import com.sfinancial.config.Config
import com.sfinancial.config.hashidConfig.ReadHashIdConfig
import com.sfinancial.config.jwtConfig.ReadJwtConfig
import com.sfinancial.config.nettyConfig.ReadNettyConfig
import org.junit.Assert
import org.junit.Test

class TestReadConfig {

    private val config = setConfig()

    private fun setConfig(): Config{
        try {
            val readHashIdConfig = ReadHashIdConfig()
            val readJwtConfig = ReadJwtConfig()
            val readNettyConfig = ReadNettyConfig()
            return Config(readHashIdConfig,readJwtConfig,readNettyConfig)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testAll(){
        testConnectionString()
        testDBname()
        testSecretJwt()
        testSecretHashid()
        testIssuer()
        testHost()
        testPort()
    }

    @Test
    fun testConnectionString(){
        try {
            val connectionString = config.getConnectionString()
            Assert.assertEquals("java.lang.String",connectionString.javaClass.name)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testDBname(){
        try {
            val dbName = config.getConnectionString()
            Assert.assertEquals("java.lang.String",dbName.javaClass.name)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretJwt(){
        try {
            val secret = config.getSecretJwt()
            Assert.assertEquals("java.lang.String",secret.javaClass.name)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretHashid(){
        try {
            val secret = config.getSecretHashid()
            Assert.assertEquals("java.lang.String",secret.javaClass.name)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testIssuer(){
        try {
            val secret = config.getIssuer()
            Assert.assertEquals("java.lang.String",secret.javaClass.name)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testHost(){
        try {
            val secret = config.getHost()
            Assert.assertEquals("java.lang.String",secret.javaClass.name)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testPort(){
        try {
            val secret = config.getPort()
            Assert.assertEquals("int",secret.javaClass.name)
        }catch (e: Exception){
            throw e
        }
    }
}