/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: TextBox
 * Author:   yushi
 * Date:     2019/4/19 10:13
 * Description: 文本框类：具体构件类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈文本框类：具体构件类〉
 *
 * @author yushi
 * @create 2019/4/19
 * @since 1.0.0
 */
public class TextBox extends Component {
    private static final Logger logger = LoggerFactory.getLogger(TextBox.class);

    @Override
    public void display() {
        logger.info("显示文本框");
    }
}