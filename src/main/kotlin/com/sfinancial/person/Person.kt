package com.sfinancial.person

import com.sfinancial.Address.Address

open class Person(
        private var name: String,
        private var lastName: String,
        private var birth: String,
        private var document: String,
        private var address: Address
): PersonInterface{
}