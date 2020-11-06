package sFinancial.config

import com.sfinancial.config.Config
import com.sfinancial.config.databaseConfig.ReadMongoConfig
import com.sfinancial.config.hashidConfig.ReadHashIdConfig
import com.sfinancial.config.jwtConfig.ReadJwtConfig
import com.sfinancial.config.nettyConfig.ReadNettyConfig
import org.junit.Assert
import org.junit.Test

class TestReadConfig {

    @Test
    fun testConnectionString(){
        try {
            val connectionString = ReadMongoConfig().getConnectionString()
            println(connectionString)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testDBname(){
        try {
            val dbName = ReadMongoConfig().getDatabaseName()
            println(dbName)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretJwt(){
        try {
            val secret = ReadJwtConfig().getSecretJwt()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretHashid(){
        try {
            val secret = ReadHashIdConfig().getSecretHashid()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testIssuer(){
        try {
            val issuer = ReadJwtConfig().getIssuer()
            println(issuer)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testHost(){
        try {
            val host = ReadNettyConfig().getHost()
            println(host)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testPort(){
        try {
            val port = ReadNettyConfig().getPort()
            println(port)
        }catch (e: Exception){
            throw e
        }
    }
}