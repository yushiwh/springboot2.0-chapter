/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BarrelSort
 * Author:   nick
 * Date:     2019/9/10 8:44
 * Description: 桶排序
 * History:
 */
package com.ys.service.sort;

import org.springframework.stereotype.Component;

/**
 * 〈桶排序〉
 * <p>
 * 如果排列10个数字，需要11个桶，也就是多一个
 * 比如0-10实际上是11个数字
 * <p>
 * 先支持正整数。负整数可以先分成两个数组进行绝对值后，然后再去取负数
 * 负数的方法可以参考——基数排序法（桶排序的升级）radixSortByNagetive
 * <p>
 * /**
 * * 基数排序方法
 * * 支持负数
 * * 方法就是先把正负数分成2个数组，然后把负数数组去绝对值排序
 * * 然后将绝对值排序的数组倒序+正数数组进行拼接成一个数组
 * <p>
 *
 * @author nick
 * @create 2019/9/10
 * @since 1.0.0
 */

@Component
public class BarrelSort {
    /**
     * 桶排序的方法
     *
     * @param arr 需要排序的数组
     */
    public int[] barrelSort(int[] arr) {

        //先找到传过来的数组，最大的数
        int max = 0;
        for (int k = 0; k < arr.length; k++) {
            if (max < arr[k]) {
                max = arr[k];
            }
        }
        System.out.println("得到的最大的数：" + max + "。因此创建的桶的个数为：" + (max + 1));

        //首先创建桶
        int[] barrel = new int[max + 1];
        //将每个桶全部置为0
        for (int i = 0; i < barrel.length; i++) {
            barrel[i] = 0;
        }
        //将每个数字读到对应的桶里面
        for (int j = 0; j < arr.length; j++) {
            //将读出来的数放到对应的桶里面，相当于标记了这个桶
            barrel[arr[j]]++;
        }

        return barrel;


    }
}