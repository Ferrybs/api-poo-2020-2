package com.sfinancial.category

import com.sfinancial.admin.idAdmin.IdAdminInterface

interface CategoryInterface {
    fun cId(idAdminInterface: IdAdminInterface)
    fun getIdCategory(): String
    fun verifier():Boolean
    fun getPriority():Int
    fun getName(): String
}