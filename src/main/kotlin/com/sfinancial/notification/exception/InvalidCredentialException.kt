package com.sfinancial.notification.exception

import java.lang.RuntimeException

class InvalidCredentialException(
        message: String? = null
): RuntimeException(message)