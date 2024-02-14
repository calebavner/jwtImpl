package debit.manager.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import debit.manager.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String tokenGen(User u) {
        return JWT.create()
            .withIssuer("msg")
            .withSubject(u.getEmail())
            .withClaim("id", u.getId())
            .withExpiresAt(LocalDateTime.now()
                .plusMinutes(10)
                .toInstant(ZoneOffset.of("-03:00"))
            ).sign(Algorithm.HMAC256("secret"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secret"))
            .withIssuer("msg")
            .build().verify(token)
            .getSubject();
    }
}
