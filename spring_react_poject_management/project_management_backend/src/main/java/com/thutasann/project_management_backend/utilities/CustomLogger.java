package com.thutasann.project_management_backend.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomLogger {

    private final Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public void logInfo(String message, Object... args) {
        logger.info(formatMessage(message, args));
    }

    public void logWarn(String message, Object... args) {
        logger.warn(formatMessage(message, args));
    }

    public void logError(String message, Throwable throwable, Object... args) {
        logger.error(formatMessage(message, args), throwable);
    }

    public void logDebug(String message, Object... args) {
        logger.debug(formatMessage(message, args));
    }

    private String formatMessage(String message, Object... args) {
        return String.format(message, args);
    }
}