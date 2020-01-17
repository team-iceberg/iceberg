package iceberg.exceptions;

import iceberg.models.ErrorResponse;
import iceberg.utils.ReactiveLogUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * Controller used to handle various common exceptions, namely {@link ServiceException}.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    private static final Log LOGGER = LogFactory.getLog(ExceptionHandlerController.class);

    /**
     * Handle ServiceException exception
     *
     * @param e the exception
     * @return an error message
     */
    @ExceptionHandler(ServiceException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleServiceException(ServiceException e) {
        final String message = e.getMessage();
        return ReactiveLogUtils.error(LOGGER, message, e).then(Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder().code("server-error").message(message).build())));
    }

    /**
     * Handle DaoException
     *
     * @param e the exception
     * @return an error message
     */
    @ExceptionHandler(DaoException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleDaoException(DaoException e) {
        final String message = e.getMessage();
        return ReactiveLogUtils.error(LOGGER, message, e).then(Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder().code("server-error").message(message).build())));
    }

    /**
     * Handle ResourceException
     *
     * @param e the exception
     * @return an error message
     */
    @ExceptionHandler(ResourceException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleResourceException(ResourceException e) {
        final String message = e.getMessage();
        return ReactiveLogUtils.warn(LOGGER, message).then(Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder().code("server-error").message(message).build())));
    }

    /**
     * Handle ResourceException
     *
     * @param e the exception
     * @return an error message
     */
    @ExceptionHandler(ForbiddenException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleForbiddenException(ForbiddenException e) {
        final String message = e.getMessage();
        return ReactiveLogUtils.warn(LOGGER, message).then(Mono
                .just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().code("forbidden-error").message(message).build())));
    }

    /**
     * Handle DuplicateException
     *
     * @param e the exception
     * @return an error message
     */
    @ExceptionHandler(DuplicateException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleDuplicateError(DuplicateException e) {
        final String message = e.getMessage();
        return ReactiveLogUtils.warn(LOGGER, message).then(Mono
                .just(ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse.builder().code("already-exists").message(message).build())));
    }
}
