package iceberg.exceptions;

/**
 * @author norsys Exception lancée en cas d'erreur au niveau du Service
 */
public class ForbiddenException extends RuntimeException {

    /**
     * Crée l'exception avec un message d'erreur
     *
     * @param message message d'erreur
     */
    public ForbiddenException(String message) {
        super(message);
    }

    /**
     * Crée l'exception avec une exception source
     *
     * @param e exception source
     */
    public ForbiddenException(Throwable e) {
        super(e);
    }

}

