package com.sfinancial.notification.exception

import java.lang.RuntimeException

class InvalidCredential(
        message: String? = null
): RuntimeException(message)