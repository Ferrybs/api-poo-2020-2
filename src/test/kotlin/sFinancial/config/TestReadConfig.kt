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
    fun getConfig(): Config {
        return config
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
            println(connectionString)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testDBname(){
        try {
            val dbName = config.getConnectionString()
            println(dbName)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretJwt(){
        try {
            val secret = config.getSecretJwt()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretHashid(){
        try {
            val secret = config.getSecretHashid()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testIssuer(){
        try {
            val issuer = config.getIssuer()
            println(issuer)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testHost(){
        try {
            val host = config.getHost()
            println(host)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testPort(){
        try {
            val port = config.getPort()
            println(port)
        }catch (e: Exception){
            throw e
        }
    }
}