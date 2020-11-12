package com.sfinancial.payment.card

interface CardInterface {
    fun verifier():Boolean
    fun getId(): String
}