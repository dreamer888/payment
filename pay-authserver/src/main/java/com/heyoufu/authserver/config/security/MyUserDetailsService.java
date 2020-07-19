package com.heyoufu.authserver.config.security;

import com.heyoufu.authserver.service.UserInfoService;
import com.heyoufu.pay.common.constant.RedisConstant;
import com.heyoufu.pay.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * xzm 2020-5-18
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoService userAccountService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo usernameAccount = userAccountService.findByUsername(username);
        if (usernameAccount != null) {
            return new org.springframework.security.core.userdetails.User(username, usernameAccount.getPassword(),
                    authorities(usernameAccount.getId()));
        }
        UserInfo phoneAccount = userAccountService.findByPhone(username);
        if (phoneAccount != null) {
            String key = RedisConstant.SMS_LOGIN_CODE + username;
            String redisCode = redisTemplate.opsForValue().get(key);
            if (redisCode == null) {
                throw new RuntimeException("验证码过期");
            }
            return new org.springframework.security.core.userdetails.User(username, passwordEncoder.encode(redisCode),
                    authorities(usernameAccount.getId()));
        }
        return null;
    }

    private List<SimpleGrantedAuthority> authorities(Long userId) {
        List<String> roles = userAccountService.findRoles(userId);
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
