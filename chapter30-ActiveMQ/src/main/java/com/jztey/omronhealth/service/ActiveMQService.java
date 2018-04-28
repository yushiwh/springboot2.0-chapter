package com.jztey.omronhealth.service;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 处理欧姆龙数据的接口
 *
 * @author yushi 2018-02-27
 */
@RequestMapping("/activemq")
@ResponseBody

public interface ActiveMQService {


    /**
     *
     * @return
     */

    @RequestMapping(value = "/send", method = RequestMethod.GET)
   String saveValueMemberidOmronidBinding();


}
