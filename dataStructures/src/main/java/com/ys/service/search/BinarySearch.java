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

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * 一定是在一个有序的数组里面查找，如果不是，首先要进行排序
 *
 * @author nick
 * @create 2019/9/5
 * @since 1.0.0
 */
@Component
public class BinarySearch {
    // 二分查找算法

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        // 向 右递归
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
            // 向左递归
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

    //完成一个课后思考题:
    /*
     * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     *
     * 思路分析
     * 1. 在找到mid 索引值，不要马上返回
     * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 4. 将Arraylist返回
     */

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        System.out.println("hello~");
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        // 向 右递归
        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
            // 向左递归
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
//			 * 思路分析
//			 * 1. 在找到mid 索引值，不要马上返回
//			 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 4. 将Arraylist返回

            List<Integer> resIndexlist = new ArrayList<Integer>();
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while ( true ) {
                //退出
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                //temp左移
                temp -= 1;
            }
            resIndexlist.add(mid);

            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while ( true ) {
                //退出
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                //temp右移
                temp += 1;
            }

            return resIndexlist;
        }

    }
}