package com.sfinancial.config

import com.sfinancial.config.readHashidConfig.ReadHashIdInterface
import com.sfinancial.config.readNettyConfig.ReadNettyConfigInterface

interface ConfigInterface: ReadNettyConfigInterface,ReadHashIdInterface {
}