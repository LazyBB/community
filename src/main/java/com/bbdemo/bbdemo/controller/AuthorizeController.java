package com.bbdemo.bbdemo.controller;

import com.bbdemo.bbdemo.dto.AccessToken;
import com.bbdemo.bbdemo.dto.GithubUser;
import com.bbdemo.bbdemo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state){
        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id(ClientId);
        accessToken.setClient_secret(ClientSecret);
        accessToken.setCode(code);
        accessToken.setRedirect_uri(RedirectUri);
        accessToken.setState(state);
        String accessToken1 = githubProvider.getAccessToken(accessToken);
        GithubUser user = githubProvider.githubUser(accessToken1);
        System.out.println(user.getName());
        return "index";
    }
}
