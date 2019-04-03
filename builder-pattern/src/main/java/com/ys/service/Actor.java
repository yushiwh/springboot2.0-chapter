/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Actor
 * Author:   yushi
 * Date:     2019/4/3 14:18
 * Description: Actor角色类：复杂产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import lombok.Data;

/**
 * 〈Actor角色类：复杂产品〉
 * 考虑到代码的可读性，只列出部分成员属性，且成员属性的类型均为String，真实情况下，有些成员属性的类型需自定义
 *
 * @author yushi
 * @create 2019/4/3
 * @since 1.0.0
 */
@Data
public class Actor {
    /**
     * 角色类型
     */
    private String type;
    /**
     * 性别
     */
    private String sex;
    /**
     * //脸型
     */
    private String face;
    /**
     * //服装
     */
    private String costume;
    /**
     * //发型 
     */
    private String hairstyle;
}