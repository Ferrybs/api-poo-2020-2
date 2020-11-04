package sFinancial.server

import com.sfinancial.server.netty.NettyFactory
import org.junit.Test
import sFinancial.config.TestReadConfig

class TestServer {

    private val nettServer = getNettyServer()

    private fun getNettyServer(): NettyFactory {
        try {
            val config = TestReadConfig().getConfig()
            return NettyFactory(config)
        }catch (e: Exception){
            throw e
        }
    }

    @Test
    fun testConnection(){
        try {
            nettServer.connect()
        }catch (e: Exception){
            throw e
        }
    }
}