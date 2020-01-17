package iceberg.exceptions;

/**
 * Exception lancé en cas d'erreur au niveau du Service
 */
public class DuplicateException extends RuntimeException {

    /**
     * Crée l'exception avec un message d'erreur
     *
     * @param message message d'erreur
     */
    public DuplicateException(String message) {
        super(message);
    }
}
