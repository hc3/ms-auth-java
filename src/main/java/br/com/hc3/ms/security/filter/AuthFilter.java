package br.com.hc3.ms.security.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class AuthFilter extends GenericFilterBean {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = null;

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(req, res);
    }
}
