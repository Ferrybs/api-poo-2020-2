package com.sfinancial.database

import ClassifierAccount
import com.sfinancial.account.AdminAccount
import com.sfinancial.account.FinancialAccount
import com.sfinancial.account.UserAccount
import com.sfinancial.address.Address
import com.sfinancial.category.Category
import com.sfinancial.group.User
import com.sfinancial.login.LoginInterface
import com.sfinancial.payment.card.CardInterface
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.person.Person
import com.sfinancial.transaction.Transaction

interface DBInterface {
    fun insertNewAccountUser(userAccount: UserAccount)
    fun insertNewCreditCard(userAccount: UserAccount, creditCard: CreditCard)
    fun insertNewCategory(userAccount: UserAccount,category: Category)
    fun insertNewTransaction(creditCard: CreditCard,transaction: Transaction)

    fun getUserAccount(loginInterface: LoginInterface): UserAccount
    fun getUserAccount(creditCard: CreditCard): UserAccount
    fun getUserAccount(transaction: Transaction) : UserAccount
    fun getCreditCard(creditCardInterface: CardInterface): CreditCard
    fun getUserAccount(person: Person) : UserAccount
    fun getUserAccount(user: User):UserAccount

    fun updateCategory(userAccount: UserAccount, category: Category)
    fun updateAddress(userAccount: UserAccount, address: Address)
    fun updateTransaction(transaction: Transaction)
    fun updateUserPerson(userAccount: UserAccount, person: Person)
    fun updateUser(user: User)

    fun deleteCreditCard(creditCard: CreditCard)
    fun deleteAddress(userAccount: UserAccount)
    fun deleteCategory(userAccount: UserAccount,category: Category)
    fun deleteTransaction(transaction: Transaction)

    fun insertNewClassifierAccount(classifierAccount: ClassifierAccount)

    fun getClassifierAccount(): ClassifierAccount

    fun insertNewFinancialAccount(financialAccount: FinancialAccount)
    fun getFinancialAccount():FinancialAccount

    fun insertNewAdminAccount(adminAccount: AdminAccount)
    fun getAdminAccount(loginInterface: LoginInterface): AdminAccount
}