/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: DubboServiceImpl
 * Author:   yushi
 * Date:     2018/10/16 11:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jztey.omronhealth.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jztey.omronhealth.entity.Student;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yushi
 * @create 2018/10/16
 * @since 1.0.0
 */
// 注册为 Dubbo 服务,注意导入的是dubbo的service
@Service(version = "1.0.0")
@Component
public class DubboServiceImpl implements DubboService {

    @Override
    public String testDubbo(Student student) {

        String str = "姓名-->" + student.getName() + "$$$$$$$" + "年龄--->" + student.getAge();
        return str;

    }
}