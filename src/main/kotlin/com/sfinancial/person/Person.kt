package com.sfinancial.person

import com.sfinancial.Address.Address

open class Person(
        private var name: String? = null,
        private var lastName: String? = null,
        private var birth: String? = null,
        private var document: String? = null,
        private var address: Address? = null
): PersonInterface{
        override fun verifier(): Boolean {
                if (address != null){
                      val hasNull = listOf(
                              name,
                              lastName,
                              birth,
                              document
                      ).any { it == null }
                        if (!hasNull && address!!.verifier()){
                                return true
                        }
                }
                return false
        }

}