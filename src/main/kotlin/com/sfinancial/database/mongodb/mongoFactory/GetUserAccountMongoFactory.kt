package com.sfinancial.database.mongodb.mongoFactory

import com.mongodb.client.MongoDatabase
import com.sfinancial.account.UserAccount
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.notification.exception.FailedFindException
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.Person
import com.sfinancial.transaction.Transaction
import org.litote.kmongo.and
import org.litote.kmongo.findOne
import org.litote.kmongo.util.KMongoUtil

class GetUserAccountMongoFactory(
        database: MongoDatabase
) : MongoFactory(database) {

    fun get(loginInterface: LoginInterface): UserAccount{
        try {
            val coll = getCollUserAccount()
            val login = coll.findOne(
                    "{'user.username': '${loginInterface.getUsername()}'," +
                            "'user.password': '${loginInterface.getPassword()}'}")
            if (login!=null) return login
            throw InvalidCredentialException("Invalid Credential!")
        }catch (e: Exception){
            throw e
        }
    }
    fun get(transaction: Transaction): UserAccount {
        try {
            val coll = getCollPayment()
            val credit = coll.findOne(
                    "{'transaction.idTransaction':'${transaction.getIdTransaction()}'}"
            )
            if (credit != null){
                val number = credit.getNumber()
                val coll2 = getCollUserAccount()
                val userAccount = coll2.findOne("{payment:'$number'}")
                if (userAccount!=null){
                    return userAccount
                }
            }
            throw FailedFindException("Failed to find transaction!")
        }catch (e: Exception){
            throw e
        }
    }
    fun get(creditCard: CreditCard): UserAccount {
        try{
            val coll = getCollUserAccount()
            val userAccount = coll.findOne("{'payment':'${creditCard.getNumber()}'}")
            if (userAccount != null){
                return userAccount
            }else{
                throw FailedFindException("Failed to find Account!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun get(user: User): UserAccount {
        try{
            val coll = getCollUserAccount()
            val userAccount = coll.findOne("{'user.username':'${user.getUsername()}'}")
            if (userAccount != null){
                return userAccount
            }else{
                throw FailedFindException("Failed to find Account!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun get(person: Person): UserAccount {
        try{
            val coll = getCollUserAccount()
            val userAccount = coll.findOne("{'user.person.document':'${person.getDocument()}'}")
            if (userAccount != null){
                return userAccount
            }else{
                throw FailedFindException("Failed to find Account!")
            }
        }catch (e: Exception){
            throw e
        }
    }
    fun get(userAccount: UserAccount): UserAccount {
        try{
            val coll = getCollUserAccount()
            val find = coll.findOne("{'idAccount':'${userAccount.getIdAccount()}'}")
            if (find != null){
                return find
            }else{
                throw FailedFindException("Failed to find Account!")
            }
        }catch (e: Exception){
            throw e
        }
    }

}