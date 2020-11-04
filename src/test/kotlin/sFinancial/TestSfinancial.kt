package sFinancial

import org.junit.Test
import sFinancial.config.TestReadNettyConfig
import sFinancial.mongodb.TestMongo


class TestSfinancial {

    @Test
    fun testSfinancial(){
        TestMongo().testAll()
        TestReadNettyConfig().testAll()
    }

}