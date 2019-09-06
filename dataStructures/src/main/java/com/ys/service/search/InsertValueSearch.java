/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BubbleSort
 * Author:   nick
 * Date:     2019/8/1 14:35
 * Description: 冒泡排序
 * History:
 */
package com.ys.service.search;

import org.springframework.stereotype.Component;

/**
 * 插值查找算法
 * 编写插值查找算法
 * 自适应中间值，可以有效减少查找的次数
 * //说明：插值查找算法，也要求数组是有序的
 *
 * @author nick
 * @create 2019/9/6
 * @since 1.0.0
 */

@Component
public class InsertValueSearch {
    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("插值查找次数~~");

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        // 求出mid, 自适应，中间索引.算法很牛逼
        //*******自适应的公式，不是二分查找中的每次对半取值*********
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        // 说明应该向右边递归
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}