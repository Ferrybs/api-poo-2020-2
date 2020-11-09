package sFinancial.config

import com.sfinancial.config.mongoConfig.MongoConfigEnv
import com.sfinancial.config.hashidConfig.HashIdConfigEnv
import com.sfinancial.config.jwtConfig.JwtConfigEnv
import com.sfinancial.config.nettyConfig.NettyConfigEnv
import org.junit.Test

class EnvConfigTest {

    @Test
    fun testConnectionString(){
        try {
            val connectionString = MongoConfigEnv().getConnectionString()
            println(connectionString)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testDBname(){
        try {
            val dbName = MongoConfigEnv().getDatabaseName()
            println(dbName)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretJwt(){
        try {
            val secret = JwtConfigEnv().getSecretJwt()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testSecretHashid(){
        try {
            val secret = HashIdConfigEnv().getSecretHashid()
            println(secret)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testIssuer(){
        try {
            val issuer = JwtConfigEnv().getIssuer()
            println(issuer)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testHost(){
        try {
            val host = NettyConfigEnv().getHost()
            println(host)
        }catch (e: Exception){
            throw e
        }
    }

//    @Test
//    fun testPort(){
//        try {
//            val port = EnvNettyConfig().getPort()
//            println(port)
//        }catch (e: Exception){
//            throw e
//        }
//    }
}