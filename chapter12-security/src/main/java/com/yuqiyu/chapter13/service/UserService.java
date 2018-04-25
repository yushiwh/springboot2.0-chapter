package com.yuqiyu.chapter13.service;

import com.yuqiyu.chapter13.entity.User;

import com.yuqiyu.chapter13.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/18
 * Time：22:40
 * 码云：http://git.oschina.net/jnyqy
 * <p>
 * 实现SpringSecurity内的UserDetailsService接口来完成自定义查询用户的逻辑
 * <p>
 * ========================
 */
public class UserService implements UserDetailsService {
    @Autowired
    UserJPA userJPA;

    /**
     * 实现UserDetailsService接口需要完成loanUserByUsername重写，
     * 我们使用UserJPA内的findByUsername方法从数据库中读取用户，并将用户作为方法的返回值。
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJPA.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("未查询到用户：" + username + "信息！");
        }
        return user;
    }
}
