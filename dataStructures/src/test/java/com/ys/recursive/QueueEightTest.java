/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: QueueEightTest
 * Author:   nick
 * Date:     2019/7/25 10:24
 * Description: 八皇后问题测试
 * History:
 */
package com.ys.recursive;

import com.ys.Tester;
import com.ys.service.recursive.QueueEight;
import org.junit.Test;

import java.util.Map;

/**
 * 〈八皇后问题测试〉
 *
 * @author nick
 * @create 2019/7/25
 * @since 1.0.0
 */
public class QueueEightTest extends Tester {
    @Test
    public void createTest() throws Exception {
        //测试一把 ， 8皇后是否正确
        QueueEight queue8 = new QueueEight();
        Map<String, Integer> map = queue8.check(0);
        System.out.printf("一共有%d解法", map.get("count"));
        System.out.printf("一共判断冲突的次数%d次", map.get("judgeCount")); // 1.5w
    }
}