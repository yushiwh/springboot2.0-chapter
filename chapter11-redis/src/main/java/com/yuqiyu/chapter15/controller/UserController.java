package com.yuqiyu.chapter15.controller;

import com.yuqiyu.chapter13.entity.User;
import com.yuqiyu.chapter13.jpa.UserJPA;
import com.yuqiyu.chapter15.service.CacheLoadable;
import com.yuqiyu.chapter15.service.CacheTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/14
 * Time：23:32
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@RestController
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private CacheTemplate<List<User>> cacheTemplate;

    @RequestMapping(value = "/list")
    public List<User> list() {
        String id = "all";
        // 设置Key值
        String queryKey = "city_" + id;
        List<User> result = cacheTemplate.getCache(queryKey, 60, TimeUnit.SECONDS, null, new CacheLoadable<List<User>>() {

            @Override
            public List<User> load() {
                List<User> city = userJPA.findAll();
                return city;
            }

        });
        return result;
    }

    @RequestMapping(value = "/add")
    public String add() {
        User userEntity = new User();
        userEntity.setName("测试");
        userEntity.setAddress("测试地址");
        userEntity.setAge(21);
        userJPA.save(userEntity);
        return "用户信息添加成功";
    }

    /**
     * 根据条件自定义编写删除SQL
     *
     * @return
     */
    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere() {
        String id = "123456";
        userJPA.deleteQuery("admin", "123456");

        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            System.out.println("删除缓存数据成功");
        }
        return "自定义SQL删除数据成功";


    }


}
