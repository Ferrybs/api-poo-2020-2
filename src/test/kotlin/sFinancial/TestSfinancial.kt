package sFinancial

import org.junit.Test
import sFinancial.mongodb.TestMongo

class TestSfinancial {

    @Test
    fun testSfinancial(){
        TestMongo().testConnection()
    }

}