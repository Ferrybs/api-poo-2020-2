package sFinancial

import org.junit.Test
import sFinancial.config.TestNettyConfig
import sFinancial.mongodb.TestMongo


class TestSfinancial {

    @Test
    fun testSfinancial(){
        TestMongo().testAll()
        TestNettyConfig().testAll()
    }

}