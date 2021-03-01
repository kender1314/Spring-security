package com.example.demo.service.impl;

import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.entity.User userByUsername = userRepository.getUserByUsername(username);
        if (userByUsername == null){
            throw new UsernameNotFoundException("用户名不存在！");
        }

        //也可以使用角色名进行登录
        List<GrantedAuthority> roles = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        return new User(userByUsername.getUsername(), new BCryptPasswordEncoder().encode(userByUsername.getPassword()), roles);
    }
}
