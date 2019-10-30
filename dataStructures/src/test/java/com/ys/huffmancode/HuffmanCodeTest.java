/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ArrBinaryTreeTest
 * Author:   nick
 * Date:     2019/9/17 9:12
 * Description: 测试顺序存储二叉树的遍历
 * History:
 */
package com.ys.huffmancode;

import com.ys.Tester;
import com.ys.service.huffmancode.HuffmanCode;
import com.ys.service.huffmancode.Node;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * 霍夫曼编码测试
 *
 * @author nick
 * @create 2019/9/17
 * @since 1.0.0
 */
public class HuffmanCodeTest extends Tester {

    @Autowired
    private HuffmanCode huffmanCode;

    @Test
    public void testHuffmanTree() throws Exception {
        //////////测试压缩文件/////////
        String srcFile = "d://Uninstall.xml";
        String dstFile = "d://Uninstall.zip";

        huffmanCode.zipFile(srcFile, dstFile);
        System.out.println("压缩文件ok~~");


        ///////测试解压文件///////
        String zipFile1 = "d://Uninstall.zip";
        String dstFile1 = "d://Uninstall2.xml";
        huffmanCode.unZipFile(zipFile1, dstFile1);
        System.out.println("解压成功!");

        /////*************用封装的方法进行压缩************///////////////
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40

        byte[] huffmanCodesBytes = huffmanCode.huffmanZip(contentBytes);
        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodesBytes) + " 长度= " + huffmanCodesBytes.length);
        /////**************用封装的方法进行压缩结束********///////////////

        //测试一把byteToBitString方法
        //System.out.println(byteToBitString((byte)1));
        //byte[] sourceBytes = huffmanCode.decode(huffmanCodes, huffmanCodesBytes);

        //System.out.println("原来的字符串=" + new String(sourceBytes)); // "i like like like java do you like a java"


        //如何将 数据进行解压(解码)
        //分步过程
        List<Node> nodes = huffmanCode.getNodes(contentBytes);
        System.out.println("nodes=" + nodes);

        //测试一把，创建的赫夫曼树
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = huffmanCode.createHuffmanTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();
/*
		//测试一把是否生成了对应的赫夫曼编码
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		System.out.println("~生成的赫夫曼编码表= " + huffmanCodes);

		//测试
		byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
		System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));//17

		//发送huffmanCodeBytes 数组 */
    }
}