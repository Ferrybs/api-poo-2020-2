package com.sfinancial.config

import com.sfinancial.config.hasidconfig.HashIdInterface
import com.sfinancial.config.nettyconfig.ConfigNettyInterface

interface ConfigInterface: ConfigNettyInterface,HashIdInterface {
}