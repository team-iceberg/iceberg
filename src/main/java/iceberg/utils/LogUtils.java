package iceberg.utils;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Level;

/**
 * Log Utils
 */
public class LogUtils {

    private LogUtils() {
    }

    /**
     * Log a message
     *
     * @param logger  the Logger
     * @param level   the level of log
     * @param message the message
     * @param params  the message params
     */
    public static void log(Log logger, Level level, String message, Object... params) {
        log(logger, level, message, null, params);
    }

    /**
     * Log a message with a throwable
     *
     * @param logger  the Logger
     * @param level   the level of log
     * @param message the message
     * @param e       the throwable to display
     * @param params  the message params
     */
    public static void log(Log logger, Level level, String message, Throwable e, Object... params) {
        if (level == Level.INFO && logger.isInfoEnabled()) {
            logger.info(String.format(message, params), e);
        } else if (level == Level.DEBUG && logger.isDebugEnabled()) {
            logger.debug(String.format(message, params), e);
        } else if (level == Level.ERROR && logger.isErrorEnabled()) {
            logger.error(String.format(message, params), e);
        } else if (level == Level.TRACE && logger.isTraceEnabled()) {
            logger.trace(String.format(message, params), e);
        } else if (level == Level.WARN && logger.isWarnEnabled()) {
            logger.warn(String.format(message, params), e);
        } else if (level == Level.FATAL && logger.isFatalEnabled()) {
            logger.fatal(String.format(message, params), e);
        }

    }
}
