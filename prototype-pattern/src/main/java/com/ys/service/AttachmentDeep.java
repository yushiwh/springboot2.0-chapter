/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Attachment
 * Author:   yushi
 * Date:     2019/4/2 16:42
 * Description: //附件类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈//附件类〉
 *
 * @author yushi
 * @create 2019/4/2
 * @since 1.0.0
 */
@Data
public class AttachmentDeep implements Serializable {
    //附件名
    private String name;

    public void download() {
        System.out.println("下载附件，文件名为" + name);
    }

}