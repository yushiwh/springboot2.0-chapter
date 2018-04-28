package com.jztey.omronhealth.service;


import java.text.SimpleDateFormat;

import java.util.Date;


import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.jztey.omronhealth.entity.MessageVo;
import com.jztey.omronhealth.jms.Producer;


/**
 * 处理欧姆龙数据的接口实现类
 *
 * @author yushi 2018-02-27
 */
@Service
public class ActiveMQServiceImpl<T> implements ActiveMQService {

    private static final Logger logger = LoggerFactory.getLogger(ActiveMQServiceImpl.class);


    @Autowired
    private Producer producer;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveValueMemberidOmronidBinding() {


        //// 增加消息队列
        Destination destination = new ActiveMQQueue("ys.queue");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        MessageVo mv = new MessageVo();
        mv.setDateReceive(sdf.format(new Date()));
        mv.setDateSend(sdf.format(new Date()));
        mv.setDeviceDigitalId("111");
        mv.setOpenId("222");
        mv.setUpdateAt(sdf.format(new Date()));
        mv.setQueue("ys.queue");
        mv.setState(0);
        mv.setMessage("绑定用户队列");
        producer.sendMessage(destination, mv);


        return "消息发送成功";
    }


}
