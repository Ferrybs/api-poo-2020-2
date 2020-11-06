package sFinancial.config

import com.sfinancial.config.databaseConfig.EnvMongoConfig
import com.sfinancial.config.hashidConfig.EnvHashIdConfig
import com.sfinancial.config.jwtConfig.EnvJwtConfig
import com.sfinancial.config.nettyConfig.EnvNettyConfig
import org.junit.Test

class EnvConfigTest {

    @Test
    fun testConnectionString(){
        try {
            val connectionString = EnvMongoConfig().getConnectionString()
            println(connectionString)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testDBname(){
        try {
            val dbName = EnvMongoConfig().getDatabaseName()
            println(dbName)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretJwt(){
        try {
            val secret = EnvJwtConfig().getSecretJwt()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretHashid(){
        try {
            val secret = EnvHashIdConfig().getSecretHashid()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testIssuer(){
        try {
            val issuer = EnvJwtConfig().getIssuer()
            println(issuer)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testHost(){
        try {
            val host = EnvNettyConfig().getHost()
            println(host)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testPort(){
        try {
            val port = EnvNettyConfig().getPort()
            println(port)
        }catch (e: Exception){
            throw e
        }
    }
}