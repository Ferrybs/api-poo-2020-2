package com.sfinancial.admin.adminID

import org.hashids.Hashids

class CreateID(
        val secret: String
) {
    fun create(): String {
        val rand1 = (1000..99999).shuffled().first()
        val rand2 = (1000..99999).shuffled().first()
        var final = (rand1 * rand2).toLong()
        if (final < 0) final *= (-1)
        val hashids = Hashids(secret, 6, "1234567890abcdef")
        return hashids.encode(final)
    }
}