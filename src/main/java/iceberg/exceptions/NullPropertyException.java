package iceberg.exceptions;

/**
 * Exception lancé quand une propriété demandée n'existe pas
 *
 * @author norsys
 */
public class NullPropertyException extends Exception {

    /**
     * Constructeur
     *
     * @param key propriété en erreur
     */
    public NullPropertyException(String key) {
        super(String.format("La propriété '%s' n'existe pas", key));
    }
}
