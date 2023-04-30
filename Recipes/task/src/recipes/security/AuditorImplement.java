package recipes.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import recipes.model.User;
import recipes.service.RecipeUserDetails;

import java.util.Optional;


public class AuditorImplement implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(RecipeUserDetails.class::cast)
                .map(RecipeUserDetails::getUser);
    }
}
