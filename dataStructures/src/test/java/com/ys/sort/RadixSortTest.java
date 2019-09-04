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
import com.ys.service.sort.RadixSort;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * 〈归并排序测试〉
 *
 * @author nick
 * @create 2019/9/2
 * @since 1.0.0
 */
public class RadixSortTest extends Tester {

    @Autowired
    private RadixSort radixSort;

    @Test
    public void testStack() throws Exception {
        int arr[] = {53, 3, 542, 748, 14, 214};

        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort.radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        System.out.println("基数排序后 " + Arrays.toString(arr));

    }

}