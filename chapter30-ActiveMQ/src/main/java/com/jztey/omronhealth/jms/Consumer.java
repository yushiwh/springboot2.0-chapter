package com.jztey.omronhealth.jms;

import com.jztey.omronhealth.entity.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * 消息的接受者
 *
 * @author yushi 2018-03-08
 */
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private ActiveMQJms activeMQJms;

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "ys.queue")
    public void receiveQueue(MessageVo mv) {
        logger.info("队列名--->ys.queue" + "     Consumer收到的报文为:" + mv.toString());
        activeMQJms.sendOpenIdToOmron(mv);

    }
}
