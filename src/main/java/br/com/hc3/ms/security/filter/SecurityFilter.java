package br.com.hc3.ms.security.filter;

import br.com.hc3.ms.security.service.SecurityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class SecurityFilter extends AbstractAuthenticationProcessingFilter {

    public SecurityFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {

        UserCredentials userCredentials = new ObjectMapper().readValue(req.getInputStream(), UserCredentials.class);

        return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            userCredentials.getUsername(),
                            userCredentials.getPassword(),
                            Collections.<GrantedAuthority>emptyList()
                    ));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        SecurityService.addAuthentication(res, auth.getName());
    }

}
