/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: MiGongTest
 * Author:   nick
 * Date:     2019/7/24 14:48
 * Description: 迷宫测试——递归
 * History:
 */
package com.ys.recursive;

import com.ys.Tester;
import com.ys.service.recursive.MiGong;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈迷宫测试——递归〉
 *
 * @author nick
 * @create 2019/7/24
 * @since 1.0.0
 */
public class MiGongTest extends Tester {

    @Autowired
    private MiGong miGong;


    @Test
    public void createTest() throws Exception {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用1 表示墙
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
		map[1][2] = 1;
	//	map[2][2] = 1;

        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
         miGong.setWay(map, 1, 1);
      //  miGong.setWay2(map, 1, 1);

        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}