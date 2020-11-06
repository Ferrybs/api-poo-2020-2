package com.sfinancial.config

import com.sfinancial.config.mongoConfig.mongoConfigInterface
import com.sfinancial.config.hashidConfig.HashIdConfigInterface
import com.sfinancial.config.jwtConfig.JwtConfigInterface
import com.sfinancial.config.nettyConfig.NettyConfigInterface

class Config(
        private val hashIdConfigInterface: HashIdConfigInterface,
        private val jwtConfigInterface: JwtConfigInterface,
        private val nettyConfigInterface: NettyConfigInterface,
        private val mongoConfigInterface: mongoConfigInterface
): ConfigInterface {

    override fun getSecretHashid(): String {
        try {
            return hashIdConfigInterface.getSecretHashid()
        }catch (e: Exception){
            throw e
        }
    }

    override fun getSecretJwt(): String {
        try {
            return jwtConfigInterface.getSecretJwt()
        }catch (e: Exception){
            throw e
        }
    }

    override fun getConnectionString(): String {
        try {
            return mongoConfigInterface.getConnectionString()
        }catch (e: Exception){
            throw e
        }
    }

    override fun getDatabaseName(): String {
        try {
            return mongoConfigInterface.getDatabaseName()
        }catch (e: Exception){
            throw e
        }
    }

    override fun getIssuer(): String {
        try {
            return jwtConfigInterface.getIssuer()
        }catch (e: Exception){
            throw e
        }
    }

    override fun getHost(): String {
        try {
            return nettyConfigInterface.getHost()
        }catch (e: Exception){
            throw e
        }
    }

    override fun getPort(): Int {
        try {
            return nettyConfigInterface.getPort()
        }catch (e: Exception){
            throw e
        }
    }
}