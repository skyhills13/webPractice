package com.rbgroup.di;

public class MessageRenderer {
	public void render(){
		MessageProvider mp = new HelloWorldMessageProvider();
		/*HiWorld를 찍고 싶을 때는 
		MessageProvider mp = new HiWorldMessageProvider();
		message renderer클래스가 하위 구현체에 해당하는 HelloWorldMessageProvider 클래스와 tight한 coupling이 발생한 상태. 
		이 coupling을 끊어서 클래스간 의존 관계를 줄이는 것이 DI 핵심 내용 
		*/
		System.out.println(mp.getMessage());
	}
	
	public static void main(String[] args){
		MessageRenderer renderer = new MessageRenderer();
		renderer.render();	
	}
}
