/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Tester
 * Author:   yushi
 * Date:     2019/6/20 14:57
 * Description: 抽象类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys;

/**
 * 〈抽象类〉
 *
 * @author yushi
 * @create 2019/6/20
 * @since 1.0.0
 */

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class Tester {

}