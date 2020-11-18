package com.sfinancial.call

import com.sfinancial.account.UserAccount
import com.sfinancial.category.Category
import com.sfinancial.notification.exception.InvalidFieldsException

class CallUserAccountCategory(
        private val userAccount: UserAccount? = null,
        private val category: Category? = null,
) {
    fun getUserAccount(): UserAccount {
        try {
            if(userAccount != null){
                return userAccount
            }else{
                throw InvalidFieldsException("UserAccount is null!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun getCategory(): Category {
        try {
            if(category != null){
                return category
            }else{
                throw InvalidFieldsException("Category is null!")
            }
        }catch (e: Exception){
            throw e
        }
    }


}