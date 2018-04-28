package com.jztey.omronhealth.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;


import com.jztey.omronhealth.entity.MessageVo;

/**
 * 向欧姆龙提交数据
 *
 * @author yushi
 */
@Service
public class ActiveMQJms {

    private static final Logger logger = LoggerFactory.getLogger(ActiveMQJms.class);


    /**
     * 向omuron提交数据，用消息队列来控制
     */
    public void sendOpenIdToOmron(MessageVo mv) {
        System.out.println("得到发送的消息后进行处理--->" + mv);

    }
}
