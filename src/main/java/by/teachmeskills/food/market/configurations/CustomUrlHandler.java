package by.teachmeskills.food.market.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomUrlHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/api/v1/clients");
        }
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/api/v1/admin/distributors");
        }
        if (roles.contains("ROLE_DISTRIBUTOR")) {
            httpServletResponse.sendRedirect("/api/v1/distributors");
        }
    }
}