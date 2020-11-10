package com.sfinancial.payment.card

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.sfinancial.transaction.Transaction

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class CreditCard(
        private val name: String? = null,
        private val number: String? = null,
        private val validity: String? = null,
        private val since: String? = null,
        private val cid: String? = null
) {
    private val transaction = mutableListOf<Transaction>()
}