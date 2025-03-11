package org.juanrobledo.authappspring.utils;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;

public class JwtUtils {

    @Value("${security.jwt.key}")
    private String key;
    @Value("${security.jwt.time.expired}")
    private String timeExpired;

    public String generateToken(){
        Algorithm algorithm = Algorithm.HMAC256(key);
        

        return null;
    }

}
