package com.sfinancial.config

import com.sfinancial.config.mongoConfig.mongoConfigInterface
import com.sfinancial.config.hashidConfig.HashIdConfigInterface
import com.sfinancial.config.jwtConfig.JwtConfigInterface
import com.sfinancial.config.nettyConfig.NettyConfigInterface

interface ConfigInterface
    :   NettyConfigInterface,
        HashIdConfigInterface,
        JwtConfigInterface,
        mongoConfigInterface