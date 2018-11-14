package br.com.hc3.ms.security.service;

import br.com.hc3.ms.dto.UserPrincipalDTO;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class SecurityService {

    private static final long EXPIRATIONTIME = 864000000;
    private static final String SECRET = "secret";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    public String generateToken(Authentication authentication) {

        UserPrincipalDTO userPrincipalDTO = (UserPrincipalDTO) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATIONTIME);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipalDTO.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

    }

    public Long getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty.");
        }
        return false;
    }

}
