/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HashTabTest
 * Author:   nick
 * Date:     2019/9/6 15:30
 * Description: hash算法测试
 * History:
 */
package com.ys.hash;

import com.ys.service.hash.Emp;
import com.ys.service.hash.HashTab;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * 〈hash算法测试〉
 *
 * @author nick
 * @create 2019/9/6
 * @since 1.0.0
 */
public class HashTabTest {
    @Autowired
    private HashTab hashTab;

    @Test
    public void testStack() throws Exception {

        //创建哈希表,7条链表
        HashTab hashTab = new HashTab(7);

        //对hash表进行测试
        //先进行增加，再进行查询
        for (int i = 0; i < 100; i++) {
            Emp emp = new Emp(i, "nick" + i);
            hashTab.add(emp);
        }
        //遍历进行输出
        hashTab.list();
        //进行查找
        hashTab.findEmpById(23);

        // 删除
        Emp emp = new Emp(1, "1111");
        hashTab.del(emp);
        //删除完后再进行查询
        hashTab.list();
    }

}

