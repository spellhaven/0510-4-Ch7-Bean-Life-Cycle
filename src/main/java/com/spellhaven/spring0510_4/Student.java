package com.spellhaven.spring0510_4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean { //두 개의 인터페이스 다중상속받음, ㅋ

	private String name;
	private int age;
	
	// 생성자랑 게터세터 아래에도 함수 있어요~~~
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void afterPropertiesSet() throws Exception { //빈의 초기화 시점에서 자동 호출
		System.out.println("afterPropertiesSet 메소드 호출됨, ㅋ");
	}
	
	@Override
	public void destroy() throws Exception { //빈이 소멸되는 시점에서 자동 호출, ㅋ
		System.out.println("destroy 메소드 호출됨, ㅋ");

	}

}










