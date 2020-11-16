package com.sfinancial.payment.card

interface CardInterface {
    fun verifier():Boolean
    fun getNumber(): String
}