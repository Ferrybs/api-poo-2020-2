package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FailedReturnCollection(
        message: String? = null
): RuntimeException(message)