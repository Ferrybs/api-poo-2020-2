package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FileNotFoundException (
    message: String? = null
): RuntimeException(message)