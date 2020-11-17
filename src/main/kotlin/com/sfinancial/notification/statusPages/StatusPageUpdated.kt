package com.sfinancial.notification.statusPages
import java.lang.RuntimeException

class StatusPageUpdated (
    message: String? = null
): RuntimeException(message)