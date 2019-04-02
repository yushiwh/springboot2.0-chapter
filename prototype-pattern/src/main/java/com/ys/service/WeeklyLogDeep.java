/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: WeeklyLog
 * Author:   yushi
 * Date:     2019/4/2 14:35
 * Description: /工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import lombok.Data;

import java.io.*;

/**
 * 〈/工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码〉
 * 深克隆
 *
 * @author yushi
 * @create 2019/4/2
 * @since 1.0.0
 */
@Data
public class WeeklyLogDeep implements Cloneable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    //使用序列化技术实现深克隆

    public WeeklyLogDeep deepClone() throws IOException, ClassNotFoundException, OptionalDataException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);
        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLogDeep) ois.readObject();
    }
}