package com.ys.tree;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.ys.Tester;
import com.ys.service.tree.HeapSort;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈堆排序测试〉
 *
 * @author nick
 * @create 2019/9/23
 * @since 1.0.0
 */
public class HeapSortTest extends Tester {
    @Autowired
    private HeapSort heapSort;

    @Test
    public void testPolandNotation() throws Exception {
        //要求将数组进行升序排序
        //int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort.heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        //System.out.println("排序后=" + Arrays.toString(arr));
    }
}