/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: MergetSortTest
 * Author:   nick
 * Date:     2019/9/2 16:49
 * Description: 归并排序测试
 * History:
 */
package com.ys.sort;

import com.ys.Tester;
import com.ys.service.sort.MergetSort;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 〈归并排序测试〉
 *
 * @author nick
 * @create 2019/9/2
 * @since 1.0.0
 */
public class MergetSortTest extends Tester {

    @Autowired
    private MergetSort mergetSort;

    @Test
    public void testStack() throws Exception {
        //int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 80000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergetSort.mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println("归并排序后=" + Arrays.toString(arr));

    }

}