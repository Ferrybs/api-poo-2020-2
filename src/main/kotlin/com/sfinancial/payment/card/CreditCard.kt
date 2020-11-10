package com.sfinancial.payment.card

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class CreditCard(
        private val name: String? = null,
        private val number: String? = null,
        private val validity: String? = null,
        private val since: String? = null
) {
}