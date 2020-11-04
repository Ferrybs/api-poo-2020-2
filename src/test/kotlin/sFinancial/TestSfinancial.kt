package sFinancial

import org.junit.Test
import sFinancial.config.TestReadConfig
import sFinancial.mongodb.TestMongo


class TestSfinancial {

    @Test
    fun testSfinancial(){
        TestMongo().testAll()
        TestReadConfig().testAll()
    }

}