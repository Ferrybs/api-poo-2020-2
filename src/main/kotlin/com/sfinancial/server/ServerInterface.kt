package com.sfinancial.server

import com.sfinancial.database.DBInterface


interface ServerInterface{
    fun start()
    fun rDatabase(): DBInterface
}