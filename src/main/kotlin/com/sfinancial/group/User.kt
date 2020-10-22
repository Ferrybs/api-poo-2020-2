package com.sfinancial.group

import com.sfinancial.person.PersonInterface

class User(
        private var username: String? = null,
        private var password: String? = null,
        private var personInterface: PersonInterface? = null,

): GroupInterface {
    override fun getPersonInterface(): PersonInterface? {
        return personInterface
    }
}