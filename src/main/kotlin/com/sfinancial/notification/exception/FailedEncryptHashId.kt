package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FailedEncryptHashId(
        message: String? = null
): RuntimeException(message)