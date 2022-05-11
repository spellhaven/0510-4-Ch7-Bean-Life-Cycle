package com.spellhaven.spring0510_4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	
	private String name;
	private int age;
	
	// 생성자랑 게터세터 밑에 뭐 더 있다...
	public OtherStudent(String name, int age) {
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
	
	
	@PostConstruct //빈 초기화 단계에서 호출
	public void initMethod() { 
		System.out.println("initMethod 메소드 호출됨!!!");
	}
	
	@PreDestroy //빈 소멸 단계에서 호출
	public void destroyMethod() { 
		System.out.println("destroyMethod 메소드 호출됨!!!");
	}
	

}
