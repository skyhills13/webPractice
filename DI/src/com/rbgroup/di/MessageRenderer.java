package com.rbgroup.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRenderer {
	private MessageProvider messageProvider;
	
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
	
	public void render(){
		System.out.println(messageProvider.getMessage());
	}
	
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("di.xml");
		MessageRenderer renderer = (MessageRenderer)ac.getBean("messageRenderer");
		renderer.render();
		/*
		 *  프로그램에서 동적으로 클래스같의 의존관계를 없앴던 것과는 다르게, 설정 파일을 이용해서 없앴다.
			하지만 applicationContext, ClassPathXmlApplicationContext, getBean 등이 생소하고 알아야하는 API도 많다.
		 	그래서 spring은 junit으로 이것을 할 수 있게 지원해준다 . 
		 */
	}
}

