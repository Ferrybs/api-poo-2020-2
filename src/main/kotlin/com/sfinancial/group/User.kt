package com.sfinancial.group

import com.sfinancial.person.PersonInterface

class User(
        private var username: String,
        private var password: String,
        private var personInterface: PersonInterface

): GroupInterface {
    override fun getPersonInterface(): PersonInterface? {
        return personInterface
    }
}