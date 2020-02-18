package com.bbdemo.controller;

import com.bbdemo.dto.AccessToken;
import com.bbdemo.dto.GithubUser;
import com.bbdemo.mapper.UserMapper;
import com.bbdemo.model.User;
import com.bbdemo.provider.GithubProvider;
import com.bbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String ClientId;
    @Value("${github.client.secret}")
    private String ClientSecret;
    @Value("${github.redirect.uri}")
    private String RedirectUri;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/callback")

    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id(ClientId);
        accessToken.setClient_secret(ClientSecret);
        accessToken.setCode(code);
        accessToken.setRedirect_uri(RedirectUri);
        accessToken.setState(state);
        String accessToken1 = githubProvider.getAccessToken(accessToken);
        GithubUser githubUser = githubProvider.githubUser(accessToken1);
//        System.out.println(user.getName());
//        return "index";
        if (githubUser != null && githubUser.getId() != null) {
            // 成功
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatar_url());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userService.insertOrUpdate(user);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            // 失败
            return "redirect:/";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletResponse response,
                         HttpServletRequest request){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
