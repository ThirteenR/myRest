package com.thirteen.core.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.thirteen.core.norm.JWTManager;
import com.thirteen.core.norm.User;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Author: rsq0113
 * Date: 2018-09-03 11:43
 * Description:
 **/
@Component
public class UserTokenManager implements JWTManager {
    public static final String DEFAULT_TOKEN_NAME = "x-token";
    @Override
    public String createJWT(User u) {
        String sign = null;
        //HMAC
        try {
            Algorithm algorithmHS = Algorithm.HMAC256("secret");
            JWTCreator.Builder builder1 = JWT.create();
            sign  = builder1.withClaim("sub", u.getUserId())
                    .withClaim("name", u.getUserName())
                    .withClaim("admin", u.getUserRand().equals("1"))
                    .sign(algorithmHS);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sign;
    }

    @Override
    public DecodedJWT validJWT(String jwt) {
        DecodedJWT dt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            dt = verifier.verify(jwt);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            System.out.println("校验失败");
        }
        return  dt;
    }
}
