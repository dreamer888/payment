package com.heyoufu.agent.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import java.nio.charset.StandardCharsets;


@Slf4j
@RestController
@RequestMapping("/agent")
public class AuthTestController {

    @GetMapping(value = "getclaim")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object get(/*Authentication authentication*/){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String jwtToken = details.getTokenValue();
        Claims claims = Jwts.parser()
                .setSigningKey("heyoufu".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims;
    }



    @GetMapping(value = "test1")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
   // @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String test1( ){

        return "hello,  im agent";
    }
}
