package com.sfinancial.notification.exception

import java.lang.RuntimeException

class ExceptionInvalidCredential(
        message: String? = null
): RuntimeException(message)