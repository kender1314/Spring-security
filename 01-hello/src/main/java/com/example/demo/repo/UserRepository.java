package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/1 19:43
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    /**
     * 用户登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    public User getUserByUsernameAndPassword(String username, String password);

    /**
     * 获取用户信息
     * @param username username
     * @return 用户信息
     */
    public User getUserByUsername(String username);
}
