package com.yuqiyu.chapter29.bean;

import lombok.*;

/**
 * 用户实体>>>测试lombok
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/8/4
 * Time：23:07
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
/*@Getter
@Setter
@ToString*/
@Data//@Data注解就可以涵盖@ToString、@Getter、@Setter方法
@AllArgsConstructor//全部参数的构造函数的自动生成，该注解的作用域也是只有在实体类上
@NoArgsConstructor//没有参数的构造函数，使用方式与@AllArgsConstructor一致
public class UserBean {
    //名称
    private String name;
    //年龄
    private int age;
    //家庭住址
    private String address;

    public String getAddress() {
        return "sss" + address;
    }
}
