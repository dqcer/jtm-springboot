package com.dqcer.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.dqcer.jwt.annotation.JwtIgnore;
import com.dqcer.jwt.util.JwtTokenUtil;
import com.dqcer.jwt.vo.AudienceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private AudienceVo audience;

    @PostMapping("/login")
    @JwtIgnore
    public Object adminLogin(HttpServletResponse response, String username, String password) {
        // 这里模拟测试, 默认登录成功，返回用户ID和角色信息
        String userId = UUID.randomUUID().toString();
        String role = "admin";

        // 创建token
        String token = JwtTokenUtil.createJWT(userId, username, role, audience);
        log.info("### 登录成功, token={} ###", token);

        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        JSONObject result = new JSONObject();
        result.put("token", token);
        return result;
    }

    @GetMapping("/users")
    public Object userList() {
        log.info("### 查询所有用户列表 ###");
        return "good job";
    }
}