package com.jztey.omronhealth.jms;

import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.jztey.omronhealth.entity.MessageVo;

/**
 * 消息的生产者
 *
 * @author yushi 2018-03-08
 */
@Service("producer")
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    @Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsMessagingTemplate jmsTemplate;                                     // 发送消息，destination是发送到的队列，message是待发送的消息

    public void sendMessage(Destination destination, MessageVo mv) {
        logger.info("发送消息--->" + destination + mv.toString());
        jmsTemplate.convertAndSend(destination, mv);
    }
}
