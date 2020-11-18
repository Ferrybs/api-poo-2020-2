package com.sfinancial.database.mongodb.mongoFactory

import ClassifierAccount
import com.mongodb.MongoException
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.sfinancial.account.AdminAccount
import com.sfinancial.account.FinancialAccount
import com.sfinancial.account.UserAccount
import com.sfinancial.notification.exception.FailedReturnCollectionException
import com.sfinancial.payment.card.CreditCard
import org.litote.kmongo.getCollection

open class MongoFactory(
        private val database: MongoDatabase,
) {

    internal fun getCollUserAccount(): MongoCollection<UserAccount> {
        try {
            return database.getCollection()
        }catch (e: MongoException){
            throw FailedReturnCollectionException(e.message)
        }catch (e: Exception){
            throw e
        }
    }
    internal fun getCollPayment(): MongoCollection<CreditCard> {
        try {
            return database.getCollection()
        }catch (e: MongoException){
            throw FailedReturnCollectionException(e.message)
        }catch (e: Exception){
            throw e
        }
    }
    internal fun getCollClassifier(): MongoCollection<ClassifierAccount> {
        try {
            return database.getCollection()
        }catch (e: MongoException){
            throw FailedReturnCollectionException(e.message)
        }catch (e: Exception){
            throw e
        }
    }
    internal fun getCollAdmin(): MongoCollection<AdminAccount> {
        try {
            return database.getCollection()
        }catch (e: MongoException){
            throw FailedReturnCollectionException(e.message)
        }catch (e: Exception){
            throw e
        }
    }
    internal fun getCollFinancial(): MongoCollection<FinancialAccount> {
        try {
            return database.getCollection()
        }catch (e: MongoException){
            throw FailedReturnCollectionException(e.message)
        }catch (e: Exception){
            throw e
        }
    }
}