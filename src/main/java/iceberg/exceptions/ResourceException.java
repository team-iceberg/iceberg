package iceberg.exceptions;

/**
 * @author norsys Exception lancée en cas d'erreur au niveau d'une resource
 */
public class ResourceException extends RuntimeException {

    /**
     * Crée l'exception avec un message d'erreur
     *
     * @param e exception mère
     */
    public ResourceException(Exception e) {
        super(e);
    }

    /**
     * Crée l'exception ResourceException avec un message
     *
     * @param message le message à afficher
     */
    public ResourceException(String message) {
        super(message);
    }
}
