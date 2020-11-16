package com.sfinancial.transaction

interface TransactionInterface {
    fun verifier(): Boolean
    fun getIdTransaction(): String
}