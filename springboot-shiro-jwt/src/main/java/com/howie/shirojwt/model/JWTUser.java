/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: JWTUser
 * Author:   yushi
 * Date:     2019/6/18 9:09
 * Description: JWTUser的实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.howie.shirojwt.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈JWTUser的实体〉
 *
 * @author yushi
 * @create 2019/6/18
 * @since 1.0.0
 */


@Data
public class JWTUser implements Serializable {
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private String role;
    /**
     * 权限
     */
    private String permission;
    /**
     * 状态
     */
    private int ban;
}


