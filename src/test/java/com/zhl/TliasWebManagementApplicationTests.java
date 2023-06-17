package com.zhl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {
    Map<String,Object> claims = new HashMap<>();
    @Test
    public void testGetJwt(){
        String jwt =  Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"comzhl")//签名算法设定以及secret设定
                .setClaims(claims)//负载设定，也就是参数设定
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000))//令牌有效时间设定
                .compact();
        System.out.println(jwt);
    }

}
