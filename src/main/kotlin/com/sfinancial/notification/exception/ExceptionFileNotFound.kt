package com.sfinancial.notification.exception

import java.lang.RuntimeException

class ExceptionFileNotFound (
    message: String? = null
): RuntimeException(message)