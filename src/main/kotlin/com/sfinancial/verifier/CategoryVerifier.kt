package com.sfinancial.verifier

import com.sfinancial.category.CategoryInterface
import com.sfinancial.database.DBInterface

class CategoryVerifier(
        private val categoryInterface: CategoryInterface
) {

    fun verifier(): Boolean {
       try {
           if (categoryInterface.verifier()){
               return true
           }
           return false
       }catch (e: Exception){
           throw e
       }
    }
}