package iceberg.utils;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Level;
import reactor.core.publisher.Mono;

/**
 * Classe utilitaire qui permet de logger le LDAP de celui qui fait l'action.
 */
public final class ReactiveLogUtils {

    private ReactiveLogUtils() {
    }

    /**
     * Logue un message et une exception avec le LDAP de l'utilisateur connecté, si il y en a un.
     *
     * @param logger  Le Logger
     * @param level   le niveau (info, warning, error, etc.)
     * @param message le message
     * @param e       une exception
     * @param args    les arguments du message
     * @return un {@link Mono < Void >} témoignant de la complétion de l'opération
     */
    public static Mono<Void> log(Log logger, Level level, String message, Throwable e, String... args) {
        return SecurityUtils.getCurrentMail().defaultIfEmpty("Unknown").doOnNext(ldap -> logMessage(logger, level, message, e, ldap, args)).then();
    }

    /**
     * Logue un message avec le LDAP de l'utilisateur connecté, si il y en a un.
     *
     * @param logger  Le Logger
     * @param level   le niveau (info, warning, error, etc.)
     * @param message le message
     * @param args    les arguments du message
     * @return un {@link Mono < Void >} témoignant de la complétion de l'opération
     */
    public static Mono<Void> log(Log logger, Level level, String message, String... args) {
        return log(logger, level, message, null, args);
    }

    /**
     * Logue une information avec le LDAP de l'utilisateur connecté
     *
     * @param logger  le Logger
     * @param message le message
     * @param args    les arguments du message
     * @return un {@link Mono < Void >} témoignant de la complétion de l'opération
     */
    public static Mono<Void> info(Log logger, String message, String... args) {
        return log(logger, Level.INFO, message, args);
    }

    /**
     * Logue un warning avec le LDAP de l'utilisateur connecté
     *
     * @param logger  le Logger
     * @param message le message
     * @param args    les arguments du message
     * @return un {@link Mono < Void >} témoignant de la complétion de l'opération
     */
    public static Mono<Void> warn(Log logger, String message, String... args) {
        return log(logger, Level.WARN, message, args);
    }

    /**
     * Logue une erreur avec le LDAP de l'utilisateur connecté
     *
     * @param logger  le Logger
     * @param message le message
     * @param e       l'esception à logger
     * @param args    les arguments du message
     * @return un {@link Mono < Void >} témoignant de la complétion de l'opération
     */
    public static Mono<Void> error(Log logger, String message, Throwable e, String... args) {
        return log(logger, Level.ERROR, message, e, args);
    }

    /**
     * Logue un traçage avec le LDAP de l'utilisateur connecté
     *
     * @param logger  le Logger
     * @param message le message
     * @param args    les arguments du message
     * @return un {@link Mono < Void >} témoignant de la complétion de l'opération
     */
    public static Mono<Void> trace(Log logger, String message, String... args) {
        return log(logger, Level.TRACE, message, args);
    }

    /**
     * Logue un débogage avec le LDAP de l'utilisateur connecté
     *
     * @param logger  le Logger
     * @param message le message
     * @param args    les arguments du message
     * @return un {@link Mono < Void >} témoignant de la complétion de l'opération
     */
    public static Mono<Void> debug(Log logger, String message, String... args) {
        return log(logger, Level.DEBUG, message, args);
    }

    private static void logMessage(Log logger, Level level, String message, Throwable e, String ldap, Object[] args) {
        final String actualMessage = String.format("[LDAP: %s] - %s", ldap, message);
        if (e != null) {
            LogUtils.log(logger, level, actualMessage, e, args);
        } else {
            LogUtils.log(logger, level, actualMessage, args);
        }
    }
}
