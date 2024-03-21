package app.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.demo.beans.MyBean;

public class App {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configurazione.xml");

		MyBean bean = context.getBean("mybean", MyBean.class);

		bean.ciaoMondo();

		context.close();
		
	}

}
