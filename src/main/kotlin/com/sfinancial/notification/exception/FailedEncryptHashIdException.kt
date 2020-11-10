package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FailedEncryptHashIdException(
        message: String? = null
): RuntimeException(message)