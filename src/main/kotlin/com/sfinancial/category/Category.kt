package com.sfinancial.category

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.InvalidFieldsException

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Category(
        private val name: String? = null,
        private val priority: Int? = null,
        private val description: String? = null
) : CategoryInterface {
    private var idCategory: String? = null

    override fun cId(idAdminInterface: IdAdminInterface) {
        try {
            if (idCategory == null){
                idCategory = idAdminInterface.create(4)
            }
            else{
                throw InvalidFieldsException("idCategory is not null")
            }
        }catch (e: Exception){
            throw e
        }
    }

    override fun getIdCategory():String {
        try {
            if (idCategory != null){
                return idCategory.toString()
            }else
            {
                throw FailedFindException("idCategory is null!")
            }
        }catch (e: Exception){
            throw e
        }
    }


    override fun verifier(): Boolean {
        return !listOf(
                name,
                priority,
                description
        ).any { it == null }
    }
    override fun getPriority(): Int {
        try {
            if (priority != null) {
                return priority
            }
            throw InvalidFieldsException("Category does not have priority!")
        }catch (e: Exception){
            throw e
        }
    }

    override fun getName(): String {
        try {
            if (name != null) {
                return name
            }
            throw InvalidFieldsException("Category does not have name!")
        }catch (e: Exception){
            throw e
        }
    }
}