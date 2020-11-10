package com.sfinancial.notification.exception

import java.lang.RuntimeException

class FailedReturnCollectionException(
        message: String? = null
): RuntimeException(message)