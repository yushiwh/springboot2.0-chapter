package com.yuqiyu.chapter29;

import com.yuqiyu.chapter29.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j//直接添加@Slf4j就可以自动创建一个日志对象作为类内全局字段
public class LombokApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void testLombok()
	{
		//测试Getter/Setter
		UserBean user = new UserBean();
		user.setName("测试lombok");
		user.setAge(10);
		user.setAddress("测试地址");

		UserBean u = new UserBean("构造lombok",1,"测试地址");

		log.info(u.toString());
	}

}
