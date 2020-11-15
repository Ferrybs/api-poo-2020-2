package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address

class UpdateAddressMongoFactory
    (database: MongoDatabase
) : MongoFactory(database) {
    fun update(userAccount: UserAccount, address: Address){
        try {
            val coll = getCollUserAccount()

        }catch (e:Exception){
            throw e
        }
    }
}