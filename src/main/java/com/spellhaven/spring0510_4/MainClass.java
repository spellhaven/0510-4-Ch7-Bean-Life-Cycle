package com.spellhaven.spring0510_4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		/*
		 컨테이너의 생명주기와 달리, 빈Bean의 생명주기는 꽤 중요하다.
		 당연하지. 컨테이너 박스 봤냐? 무생물이잖아. 근데 콩은 생물이니까 흥망성쇠를 겪잖아.
		
		 참고로, afterPropertiesSet과 @PostConstruct(우리는 이걸로 initMethod를 만들었지)는 선후관계가 같다.
		 우리가 단지 코드상으로 재현을 먼저 불렀기 때문에 afterPropertiesSet가 먼저 나오는 것 뿐이디.
		
		 이런 걸 바로 "시점 지향"(관점 지향) 프로그래밍(Aspect Oriented Programming)이라고 부른다.
		 어떤 기능이 실행되기 전/후에 어떤 기능을 넣겠다는 것!!!
		 
		 AOP는 나중에 차차 배워가도록 하자... ㅋ. 🥰
		 */
	
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 컨테이너 ctx 생성	
		ctx.load("classpath:applicationCTX.xml"); // 컨테이너 파일 설정
		ctx.refresh();
		
		// 재현과 함께 afterPropertiesSet()과 destroy()를 살펴 보자.
		Student stu1 = ctx.getBean("jaehyun", Student.class); //컨테이너 사용
		System.out.println(stu1.getName()); // 컨테이너 사용
		
		// 메건 디 스탤리언과 함께 @PostContruct와 @Predestroy를 알아보자... 근데 왜 출력않되냐.
		// applicationCTX에서 Namespace로 context를 체크했어야 한다. 그래야 @Annotation이 인식되거든. 이제 잘 되네, ㅋ.
		OtherStudent stu2 = ctx.getBean("theeStallion", OtherStudent.class);
		System.out.println(stu2.getName()); 
		
		ctx.close(); // 컨테이너 종료
	}

}
