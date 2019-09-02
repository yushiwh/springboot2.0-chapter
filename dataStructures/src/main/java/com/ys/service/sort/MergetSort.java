/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: MergetSort
 * Author:   nick
 * Date:     2019/9/2 16:47
 * Description: 归并排序
 * History:
 */
package com.ys.service.sort;

import org.springframework.stereotype.Component;

/**
 * 〈归并排序〉
 *
 * @author nick
 * @create 2019/9/2
 * @since 1.0.0
 */
@Component
public class MergetSort {
    /**
     * 分+合方法
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            //中间索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);

        }
    }


    /**
     * 合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 初始化i, 左边有序序列的初始索引
        int i = left;
        //初始化j, 右边有序序列的初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        //继续
        while ( i <= mid && j <= right ) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 t++, i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之,将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        //左边的有序序列还有剩余的元素，就全部填充到temp
        while ( i <= mid ) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        //右边的有序序列还有剩余的元素，就全部填充到temp
        while ( j <= right ) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }


        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while ( tempLeft <= right ) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}