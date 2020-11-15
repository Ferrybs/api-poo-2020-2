package com.sfinancial.feature.doubleReceive

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*

fun Application.moduleDoubleReceive(){
    install(DoubleReceive){

    }
}