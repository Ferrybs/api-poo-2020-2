package com.sfinancial.transation

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Transaction(
        private val idTransaction: String?= null,
        private val date: String? = null,
        private val value: Double? = null,
        private val local: String? = null,
) {
    fun verifier(): Boolean{
        val hasNull = listOf(
                idTransaction,
                date,
                value,
                local
        ).any { it == null }

        return !hasNull
    }
}