/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: sparsearray
 * Author:   yushi
 * Date:     2019/6/20 14:59
 * Description: 稀疏数组测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys;

import com.ys.service.array.Sparsearray;
import com.ys.service.list.singlelinkedlist.HeroNode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈稀疏数组测试〉
 *
 * @author yushi
 * @create 2019/6/20
 * @since 1.0.0
 */
public class SparsearrayTest extends Tester {

    @Autowired
    private Sparsearray pparsearray;


    @Test
    public void createOldArray() throws Exception {
        //原始数组
        int[][] oldArray = pparsearray.createOldArray();

        //创建稀疏数组
        int[][] sparseArr = pparsearray.createSparseArr(oldArray);

        //复原成二位数组
        pparsearray.reCreateNewArray(sparseArr);
    }

}