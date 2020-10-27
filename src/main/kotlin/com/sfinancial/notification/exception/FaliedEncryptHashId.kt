package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FaliedEncryptHashId(
        message: String? = null
): RuntimeException(message)