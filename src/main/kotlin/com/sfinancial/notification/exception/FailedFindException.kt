package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FailedFindException(
    message: String? = null
): RuntimeException(message)