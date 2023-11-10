package com.server.configuration;

import java.sql.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class UserAuthProvider {
	
	String issuer = "javamedia";
	String secretKey = "jdisa2138dansk%$534ndasnj2";	

	public String createToken(String username) {
		long expirationTime = 864_000_000;
		Date now = new Date(System.currentTimeMillis());

        String token = JWT.create()
                .withSubject(username)
                .withIssuer(issuer)
				.withIssuedAt(now)
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC512(secretKey));

		return token;
	}

	public Authentication validateToken(String token) {
		Algorithm algorithm = Algorithm.HMAC512(secretKey);

		JWTVerifier verifier = JWT.require(algorithm).build();

		DecodedJWT decoded = verifier.verify(token);

       return new UsernamePasswordAuthenticationToken(decoded.getSubject(), null, null);
	}
}
