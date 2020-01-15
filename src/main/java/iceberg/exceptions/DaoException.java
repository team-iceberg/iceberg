package iceberg.exceptions;

/**
 * Exception lancé en cas d'erreur au niveau du DAO
 *
 * @author norsys
 */
public class DaoException extends RuntimeException {

    /**
     * Constructeur
     *
     * @param e exception source
     */
    public DaoException(Throwable e) {
        super(e);
    }
}
