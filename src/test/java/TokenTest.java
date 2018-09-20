import com.auth0.jwt.interfaces.DecodedJWT;
import com.thirteen.component.user.entity.UserInfo;
import com.thirteen.core.token.UserTokenManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author: rsq0113
 * Date: 2018-09-20 16:47
 * Description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TokenTest {
    @Resource
    UserTokenManager userTokenManager;
    @Test
    public void Token() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        userInfo.setUserName("Ren");
        userInfo.setUserRand("1");
        String jwt = userTokenManager.createJWT(userInfo);
        System.out.println(jwt);
        DecodedJWT decodedJWT = userTokenManager.validJWT(jwt);
        System.out.println(decodedJWT.getClaim("name").asString());
    }

}
