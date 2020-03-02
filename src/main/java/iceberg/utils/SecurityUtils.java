package iceberg.utils;

import iceberg.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

/**
 * Util class gathering methods that deal with security, mainly {@link
 * ReactiveSecurityContextHolder}.
 */
public final class SecurityUtils {

    private SecurityUtils() {
    }

    /**
     * Retrieves the current authenticated user from the security context.
     *
     * @return a fulfilled {@link Mono} if user is authenticated, or an empty one if the user is
     * anonymous.
     */
    public static Mono<User> getCurrentUser() {
        return ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication).map(Authentication::getPrincipal).cast(User.class);
    }

    /**
     * Retrieves the current authenticated user's LDAP.
     *
     * @return a fulfilled {@link Mono} if user is authenticated, or an empty one if the user is
     * anonymous.
     */
    public static Mono<String> getCurrentMail() {
        return getCurrentUser().map(User::getMail);
    }
}
