/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: MiGong
 * Author:   nick
 * Date:     2019/7/24 14:50
 * Description: 迷宫的方法——递归
 * History:
 */
package com.ys.service.recursive;

import org.springframework.stereotype.Component;

/**
 * 〈迷宫的方法——递归〉
 * 如果要找出最短路径的话，其实就是把所有的策略放到一个数组里面进行循环，都走一遍。把所有的2的个数记录下来。得到最小的个数的就是最短路径
 *
 * @author nick
 * @create 2019/7/24
 * @since 1.0.0
 */
@Component
public class MiGong {

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true, 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        // 通路已经找到ok
        if (map[6][1] == 2) {
            return true;
        } else {
            //如果当前这个点还没有走过
            if (map[i][j] == 0) {
                //按照策略 下->右->上->左  走
                // 假定该点是可以走通.
                map[i][j] = 2;
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                    //向右走
                } else if (setWay(map, i, j + 1)) {
                    return true;
                    //向上
                } else if (setWay(map, i - 1, j)) {
                    return true;
                    // 向左走
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }

    /**
     * 修改找路的策略，改成 上->右->下->左
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        // 通路已经找到ok
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果当前这个点还没有走过
            if (map[i][j] == 0) {
                //按照策略 上->右->下->左
                // 假定该点是可以走通.
                map[i][j] = 2;
                //向上走
                if (setWay2(map, i - 1, j)) {
                    return true;
                    //向右走
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                    //向下
                } else if (setWay2(map, i + 1, j)) {
                    return true;
                    // 向左走
                } else if (setWay2(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }
}