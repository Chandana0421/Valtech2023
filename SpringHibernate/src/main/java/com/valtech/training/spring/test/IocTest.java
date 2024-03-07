package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.HelloWorld;
import com.valtech.training.spring.Line;
import com.valtech.training.spring.SimpleInterest;
import com.valtech.training.spring.UtilsBean;

class IocTest {

	private ApplicationContext appContext;
	private ApplicationContext childAppContext;

	@BeforeEach
	void initialize() {
		appContext = new ClassPathXmlApplicationContext("ioc.xml");
		childAppContext = new ClassPathXmlApplicationContext(new String[] { "ioccChild.xml" }, appContext);
	}

	@Test
	void test() {
		HelloWorld hw = (HelloWorld) appContext.getBean("hw");
		assertEquals("Hello World", hw.Hello("World"));
		assertEquals(appContext.getBean("hw"), appContext.getBean("abc"));
	}

	@Test
	void testPoint() {
		System.out.println(appContext.getBean("p1"));
		assertNotEquals(appContext.getBean("p1"), appContext.getBean("p1"));
	}

	@Test
	void testPointSetterInjection() {
		System.out.println(appContext.getBean("p2"));
	}

	@Test
	void testLine() {
		System.out.println(appContext.getBean("l1"));
		System.out.println(appContext.getBean("l2"));
	}

	@Test
	void testSimpleInterest() {
		SimpleInterest si = (SimpleInterest) appContext.getBean(SimpleInterest.class);
		System.out.println(si.computeInterest(3000, 12, 3));
	}

	@Test
	void testUtilis() {
		UtilsBean ub = (UtilsBean) appContext.getBean(UtilsBean.class);
		System.out.println(ub.getNames());
		System.out.println(ub.getSettings());
		System.out.println(ub.getPoints());
	}

	@Test
	void testChildApplicationContext() {
		Line l= (Line) childAppContext.getBean(Line.class);
		System.out.println(l);
	}
}
