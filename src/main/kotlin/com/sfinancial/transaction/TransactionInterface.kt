package com.sfinancial.transaction

import com.sfinancial.admin.idAdmin.IdAdminInterface

interface TransactionInterface {
    fun verifier(): Boolean
    fun getIdTransaction(): String
    fun cIdTransaction(idAdminInterface: IdAdminInterface)
}