/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Student
 * Author:   yushi
 * Date:     2018/10/16 11:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jztey.omronhealth.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yushi
 * @create 2018/10/16
 * @since 1.0.0
 */


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student implements Serializable {
    private static final long serialVersionUID = -1L;
    String name;
    int age;

}