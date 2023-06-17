package com.zhl.controller;

import com.zhl.pojo.Emp;
import com.zhl.pojo.Result;
import com.zhl.service.EmpService;
import com.zhl.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        Emp emp1 = empService.login(emp);
        if (emp1 != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",emp1.getId());
            claims.put("name",emp1.getName());
            claims.put("username",emp1.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return emp1 != null?Result.success():Result.error("用户名或密码错误");
    }
}
