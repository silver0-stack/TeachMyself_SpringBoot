package com.example.betterme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication annotation 이 붙은 클래스가 메인 클래스다
//@SpringBootApplication 으로 인해 스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정됨
//@SpringBootApplication 이 있는 위치부터 설정을 읽기 때문에 이 클래스는 항상 프로젝트 최상단에 위치해야 함
@SpringBootApplication
public class DemoApplication {

	//SpringApplication.run 으로 내장 WAS 를 실행핢
	//외장 WAS 를 둘 수 있지만 스프링 부트에서는 내장 WAS 를 권장
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
