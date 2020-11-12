package com.sfinancial.database.mongodb

import com.sfinancial.account.UserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.mongoFactory.GetCreditCardMongoFactory
import com.sfinancial.database.mongodb.mongoFactory.GetUserAccountMongoFactory
import com.sfinancial.database.mongodb.mongoFactory.NewCreditCardMongoFactory
import com.sfinancial.database.mongodb.mongoFactory.NewUserAccountMongoFactory
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard

open class ManagementMongodb(
        connectionString: String,
        databaseName: String,
) : ConnectionMongodb(connectionString, databaseName), DBInterface {

    override fun insertNewAccountUser(userAccount: UserAccount) {
        try {
            NewUserAccountMongoFactory(getDatabase()).create(userAccount)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getUserAccount(loginInterface: LoginInterface): UserAccount {
        try {
            return GetUserAccountMongoFactory(getDatabase()).get(loginInterface)
        }catch (e: Exception){
            throw e
        }
    }

    override fun insertNewCreditCard(userAccount: UserAccount,creditCard: CreditCard) {
        try {
            NewCreditCardMongoFactory(getDatabase()).create(userAccount,creditCard)
        }catch (e: Exception){
            throw e
        }
    }

    override fun getCreditCard(creditCardInterface: CardInterface) {
        try {
            GetCreditCardMongoFactory(getDatabase()).get(creditCardInterface)
        }catch (e: Exception){
            throw e
        }
    }
}