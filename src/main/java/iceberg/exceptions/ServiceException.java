package iceberg.exceptions;

/**
 * @author norsys Exception lancée en cas d'erreur au niveau du Service
 */
public class ServiceException extends RuntimeException {

    /**
     * Crée l'exception avec un message d'erreur
     *
     * @param message message d'erreur
     */
    public ServiceException(String message) {
        super(message);
    }

}

