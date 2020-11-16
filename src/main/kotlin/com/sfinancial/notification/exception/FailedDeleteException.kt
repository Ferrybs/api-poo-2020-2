package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FailedDeleteException(
        message: String? = null
): RuntimeException(message)