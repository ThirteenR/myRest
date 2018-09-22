package com.thirteen.core.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.thirteen.core.exception.ConstException;
import com.thirteen.core.norm.JWTManager;
import com.thirteen.core.norm.User;
import com.thirteen.core.response.ResponseEnum;
import com.thirteen.core.util.DateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Author: rsq0113
 * Date: 2018-09-03 11:43
 * Description:
 **/
@Component
public class UserTokenManager implements JWTManager {
    private Logger logger = LoggerFactory.getLogger(UserTokenManager.class);
    /*token对应的响应头部字段*/
    public static final String DEFAULT_TOKEN_NAME = "x-token";
    /*token加解密的盐值*/
    private static final String SECRET = "thirteen-R";

    @Override
    public String createJWT(User u) {
        String token = null;
        //HMAC
        try {
            Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
            JWTCreator.Builder builder = JWT.create();
            token = builder.withClaim(TokenEnum.USER_ID.getValue(), u.getUserId())
                    .withClaim(TokenEnum.USER_NAME.getValue(), u.getUserName())
                    .withClaim(TokenEnum.USER_RAND.getValue(), u.getUserRand())
                    .withClaim(TokenEnum.IAT.getValue(),DateTool.getNow())
                    .withClaim(TokenEnum.EXP.getValue(),DateTool.future(60L*60L*1000L))
                    .sign(algorithmHS);
             logger.info(DateTool.future(10*1000).toString());
        } catch (UnsupportedEncodingException e) {
            logger.error("生成token失败 ——— "+e.getMessage());
            throw new ConstException(ResponseEnum.LOGIN_ERROR);
        }
        return token;
    }

    @Override
    public DecodedJWT validJWT(String jwt) {
        DecodedJWT dt = null;
        if (jwt == null || "null".equals(jwt)) {
            return dt;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(10).build();
            dt = verifier.verify(jwt);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ConstException(ResponseEnum.SUCCESS.NOT_LOGIN);
        }
        return dt;
    }
}
