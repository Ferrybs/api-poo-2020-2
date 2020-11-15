package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FailedUpdateException(
    message: String? = null
): RuntimeException(message)