package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FileNotFound (
    message: String? = null
): RuntimeException(message)