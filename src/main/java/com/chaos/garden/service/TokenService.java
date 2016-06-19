package com.chaos.garden.service;

import com.chaos.garden.model.gen.Customer;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zcfrank1st on 6/13/16.
 */
@Service
@Slf4j
public class TokenService {
    @Autowired
    private Gson gson;

    private RsaJsonWebKey rsaKey;

    public TokenService() throws JoseException {
        rsaKey = RsaJwkGenerator.generateJwk(2048);
        rsaKey.setKeyId("k1");
    }

    public String generateToken(Customer auth) throws JoseException {
        JwtClaims claims = new JwtClaims();
        claims.setClaim("auth", gson.toJson(auth));

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(rsaKey.getPrivateKey());
        jws.setKeyIdHeaderValue(rsaKey.getKeyId());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        return jws.getCompactSerialization();
    }

    public Customer verifyToken (String token) throws InvalidJwtException {
        JwtConsumer consumer = new JwtConsumerBuilder().setVerificationKey(rsaKey.getKey()).build();
        JwtClaims claims = consumer.processToClaims(token);
        return gson.fromJson((String) claims.getClaimValue("auth"), Customer.class);
    }
}
